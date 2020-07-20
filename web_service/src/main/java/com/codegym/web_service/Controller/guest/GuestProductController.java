package com.codegym.web_service.Controller.guest;

import com.codegym.dao.entity.AccessTimes;
import com.codegym.dao.entity.Brand;
import com.codegym.dao.entity.Category;
import com.codegym.dao.entity.Product;
import com.codegym.service.AccessTimesService;
import com.codegym.service.BrandService;
import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class GuestProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private AccessTimesService accessTimesService;

    private List<Product> productList;

    private List<Category> categories;

    @GetMapping("user/home-store/products")
    public ResponseEntity<List<Product>> getAllProduct() throws UnknownHostException {
        productList = productService.findAll();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00.0");
        String currentTime = sdf.format(date);
        boolean check = false;
        List<AccessTimes> accessTimesList = accessTimesService.findAll();
        int sizeAccessTimesList = accessTimesList.size();
        InetAddress localhost = InetAddress.getLocalHost();
        for (int i = 0; i < sizeAccessTimesList; i++) {
            if (accessTimesList.get(i).getDate().toString().equals(currentTime)) {
                if (!accessTimesList.get(i).getIpUser().equals(localhost.getHostAddress())) {
                    check = true;
                    break;
                }
            } else {
                if (!accessTimesList.get(sizeAccessTimesList - 1).getDate().toString().equals(currentTime)) {
                    check = true;
                    break;
                }
            }
        }
        if (sizeAccessTimesList == 0) {
            check = true;
        }
        if (check) {
            accessTimesService.add(new AccessTimes(new Date(), localhost.getHostAddress().trim()));
        }

        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

    @GetMapping("user/home-store/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }

    @GetMapping("user/home-store/{categoryId}")
    public ResponseEntity<List<Product>> getAllProductByCategoryId(@PathVariable(name = "categoryId") Integer categoryId) {
        productList = productService.findAllProductByCategoryId(categoryId);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

    @GetMapping("/user/home-store/all-brand")
    public ResponseEntity<List<Brand>> listResponseEntityBrand() {
        List<Brand> brandList = brandService.findAll();
        if (brandList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(brandList, HttpStatus.OK);
        }
    }

    @GetMapping("/user/home-store/products/{id}")
    public ResponseEntity<Product> showProduct(@PathVariable(name = "id") Integer id) {
        Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
