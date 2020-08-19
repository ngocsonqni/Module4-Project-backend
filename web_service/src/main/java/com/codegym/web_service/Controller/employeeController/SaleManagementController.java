package com.codegym.web_service.Controller.employeeController;

import com.codegym.dao.DTO.CouponDTO;
import com.codegym.dao.entity.Coupon;
import com.codegym.dao.entity.CouponDetails;
import com.codegym.dao.entity.CouponCreate;
import com.codegym.dao.entity.Product;
import com.codegym.service.CouponDetailsService;
import com.codegym.service.CouponService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
public class SaleManagementController {
    @Autowired
    private CouponService couponService;
    @Autowired
    private CouponDetailsService couponDetailsService;

    @Autowired
    private ProductService productService;

    //---------------------- list bill sprint 2 ---------------------------------
    @RequestMapping(value = "/coupon", method = RequestMethod.GET)
    public ResponseEntity<Page<Coupon>> listAllCoupon(@RequestParam("page") int page,
                                                      @RequestParam("size") int size,
                                                      @RequestParam("createdatefrom") String createDateFrom,
                                                      @RequestParam("createdateto") String createDateTo,
                                                      @RequestParam("employee") String employee,
                                                      @RequestParam("user") String user
    ) throws ParseException {
        if (createDateFrom.equals("")) {
            createDateFrom = "1900-01-01";
        }
        if (createDateTo.equals("")) {
            createDateTo = "9999-12-31";
        }
        Page<Coupon> couponPage = couponService.findAllListCoupon(PageRequest.of(page, size, Sort.by("createDate").ascending()), new SimpleDateFormat("yyyy-MM-dd").parse(createDateFrom), new SimpleDateFormat("yyyy-MM-dd").parse(createDateTo), employee, user);
        if (couponPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(couponPage, HttpStatus.OK);
    }

    //---------------------- create coupon + coupon details  ---------------------------------
    @PostMapping("/createCoupon")
    public ResponseEntity<Void> createProduct(@RequestBody CouponDTO couponDTO, UriComponentsBuilder ucBuilder) {

        CouponCreate couponCreate = new CouponCreate();
        couponCreate.setCouponId(couponDTO.getCouponId());
        couponCreate.setCreateDate(couponDTO.getCreateDate());
        couponCreate.setEmployee(couponDTO.getEmployeeId());
        couponCreate.setUser(couponDTO.getUserId());
        couponCreate.setDeleteFlag(couponDTO.getDeleteFlag());
        couponService.save(couponCreate);

        for (CouponDetails couponDetails : couponDTO.getCouponDetails()) {
            couponDetails.setCouponId(couponDTO.getCouponId());
            couponDetailsService.save(couponDetails);
        }
        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getProductId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //---------------------- get all product for create coupon  ---------------------------------
    @GetMapping("/coupon/listProducts")
    public ResponseEntity<List<Product>> getListProduct() {
        List<Product> products = productService.findAllByDeleteFlagFalse();
        return products.isEmpty() ? new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Product>>(products, HttpStatus.OK);

    }
}
