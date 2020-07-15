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
@CrossOrigin(origins = "*")
public class BrandController {
    @Autowired
    private BrandService brandService;

    //-------------------Retrieve All Brands--------------------------------------------------------
    @GetMapping("/brand")
    public ResponseEntity<List<Brand>> listBrands() {
        List<Brand> brands = brandService.findAllByDeleteFlagFalse();
        if (brands == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    //-------------------Retrieve Single Brand--------------------------------------------------------
    @GetMapping("/brand/{id}")
    public ResponseEntity<Brand> getBrand(@PathVariable Integer id) {
        Brand brand = brandService.findById(id);
        if (brand == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    //-------------------Create a Brand--------------------------------------------------------
    @PostMapping("/brand/create")
    public ResponseEntity<Void> createBrand(@RequestBody Brand brand) {
        brandService.save(brand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //-------------------Update a Brand--------------------------------------------------------
//    @PutMapping("brand/update/{id}")
//    public ResponseEntity<Brand> updateBrand(@PathVariable Integer id, @RequestBody Brand brand) {
//        Brand currentBrand = brandService.findById(id);
//        if (currentBrand == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        currentBrand.setBrandLogo(brand.getBrandLogo());
//        currentBrand.setBrandName(brand.getBrandName());
//        currentBrand.setBrandAddress(brand.getBrandAddress());
//        currentBrand.setBrandWebsite(brand.getBrandWebsite());
//        brandService.save(currentBrand);
//        return new ResponseEntity<>(currentBrand, HttpStatus.OK);
//    }

    //-------------------Delete a Brand--------------------------------------------------------
//    @PutMapping("/brand/delete/{id}")
//    public ResponseEntity<Brand> deleteBrand(@PathVariable Integer id) {
//        Brand currentBrand = brandService.findById(id);
//        if (currentBrand == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        brandService.delete(currentBrand);
//        brandService.save(currentBrand);
//        return new ResponseEntity<>(HttpStatus.OK);
//
//
//    }
}
