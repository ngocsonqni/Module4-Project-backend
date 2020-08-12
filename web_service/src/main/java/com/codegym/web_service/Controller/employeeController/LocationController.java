package com.codegym.web_service.Controller.employeeController;

import com.codegym.dao.entity.Commune;
import com.codegym.dao.entity.District;
import com.codegym.dao.entity.Province;
import com.codegym.service.CommuneService;
import com.codegym.service.DistrictService;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class LocationController {
     @Autowired(required = true)
    ProvinceService provinceService;
    @Autowired
    DistrictService districtService;
    @Autowired
    CommuneService communeService;

    @GetMapping("/location/province/list")
    public List<Province> findAll() {
        return provinceService.findAll();
    }

    @GetMapping("/location/province/getDistrict/{id}")
    public List<District> findAllDistrict(@PathVariable String id) {
        return districtService.findAllByProvinceId(id);
    }

    @GetMapping("/location/commune/{id}")
    public List<Commune> findAllCommune(@PathVariable String id) {
        return communeService.findAllByDistrictId(id);
    }

    @GetMapping("/location/province/{id}")
    public Province findProvinceById(@PathVariable String id) {
        return provinceService.findById(id);
    }
    @GetMapping("/location/district-thanh/{id}")
    public District findDistrictById(@PathVariable String id) {
        return districtService.findById(id);
    }
    @GetMapping("/location/ward/{id}")
    public Commune findWardById(@PathVariable String id) {
        return communeService.findById(id);
    }

    @GetMapping("/location/district/getCommune/{id}")
    public List<Commune> findCommuneByDistrictID(@PathVariable String id) {
        return communeService.findAllByDistrictId(id);
    }

    @GetMapping("/location/communeById/{id}")
    public Commune findCommuneByID(@PathVariable String id) {
        return communeService.findById(id);
    }

    @GetMapping(value = "/location/provinceName/{name}")
    public Province findProvinceByName(@PathVariable String name) {
        return this.provinceService.findByName(name);
    }

    @GetMapping("/location/district/{name}")
    public District findDistrictByName(@PathVariable String name) {
        return this.districtService.findByName(name);
    }

    @GetMapping("/location/communeName/{name}")
    public Commune findCommuneByName(@PathVariable String name) {
        return this.communeService.findByName(name);
    }

}
