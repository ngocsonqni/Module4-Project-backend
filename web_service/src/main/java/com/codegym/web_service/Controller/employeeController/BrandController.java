package com.codegym.web_service.Controller.employeeController;

import com.codegym.dao.entity.Brand;
import com.codegym.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse-management")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class BrandController {
    @Autowired
    private BrandService brandService;

    //-------------------Retrieve All Brands--------------------------------------------------------
    @GetMapping("/brand")
    public ResponseEntity<List<Brand>> listBrands() {
        List<Brand> brands = brandService.getAllBrand();
        if (brands == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    //-------------------Create a Brand--------------------------------------------------------
    @PostMapping("/brand/create")
    public ResponseEntity<?> createBrand(@RequestBody Brand brand) {
        if(brandService.createBrand(brand)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
