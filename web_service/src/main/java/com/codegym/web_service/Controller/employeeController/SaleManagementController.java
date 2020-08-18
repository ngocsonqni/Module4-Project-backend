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
import java.util.Date;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
        Page<Coupon> couponPage = null;
        if (!employee.equals("") && !user.equals("")) {
            couponPage = couponService.findAllListCoupon(PageRequest.of(page, size, Sort.by("createDate").descending()), new SimpleDateFormat("yyyy-MM-dd").parse(createDateFrom), new SimpleDateFormat("yyyy-MM-dd").parse(createDateTo), employee, user);
        } else if (employee.equals("") && !user.equals("")) {
            couponPage = couponService.findAllListCouponWithUser(PageRequest.of(page, size, Sort.by("createDate").descending()), new SimpleDateFormat("yyyy-MM-dd").parse(createDateFrom), new SimpleDateFormat("yyyy-MM-dd").parse(createDateTo), user);
        } else if (user.equals("") && !employee.equals("")) {
            couponPage = couponService.findAllListCouponWithEmployee(PageRequest.of(page, size, Sort.by("createDate").descending()), new SimpleDateFormat("yyyy-MM-dd").parse(createDateFrom), new SimpleDateFormat("yyyy-MM-dd").parse(createDateTo), employee);
        } else {
            couponPage = couponService.findAllListCouponWithBlank(PageRequest.of(page, size, Sort.by("createDate").descending()), new SimpleDateFormat("yyyy-MM-dd").parse(createDateFrom), new SimpleDateFormat("yyyy-MM-dd").parse(createDateTo));
        }
        return couponPage.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(couponPage, HttpStatus.OK);
    }

    //---------------------- Hieu Nguyen API ---------------------------------

    //---------------------- Get Coupon By Id ---------------------------------
    @GetMapping("/coupon/{id}")
    public ResponseEntity<Coupon> getCoupon(@PathVariable("id") Integer id) {
        Coupon coupon = couponService.findById(id);
        return coupon == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(coupon, HttpStatus.OK);

    }

    //---------------------- Delete a Coupon ---------------------------------
    @PatchMapping("/coupon/delete/{id}")
    public ResponseEntity<Coupon> deleteCoupon(@PathVariable Integer id) {
        Coupon currentCoupon = couponService.findById(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        String couponDate = sdf.format(currentCoupon.getCreateDate());
        if (currentCoupon == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (couponDate.equals(date)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            couponService.remove(currentCoupon);
            couponService.save(currentCoupon);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    //---------------------- Delete Many Coupon ---------------------------------
    @GetMapping("/coupon/deletes/{id}")
    public ResponseEntity<Coupon> deleteManyCoupon(@PathVariable Integer id) {
        Coupon currentCoupon = couponService.findById(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        String couponDate = sdf.format(currentCoupon.getCreateDate());
        if (currentCoupon == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (couponDate.equals(date)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            couponService.remove(currentCoupon);
            couponService.save(currentCoupon);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
//---------------------- Hieu Nguyen API - END ---------------------------------

