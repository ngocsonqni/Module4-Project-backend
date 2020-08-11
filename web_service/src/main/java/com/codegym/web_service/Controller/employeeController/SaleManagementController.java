package com.codegym.web_service.Controller.employeeController;

import com.codegym.dao.entity.Coupon;
import com.codegym.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
public class SaleManagementController {
    @Autowired
    private CouponService couponService;

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
}
