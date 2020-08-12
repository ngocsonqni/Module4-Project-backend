package com.codegym.web_service.Controller.employeeController;

import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.codegym.dao.entity.Category;
import com.codegym.dao.entity.Product;
import com.codegym.dao.entity.Unit;
import com.codegym.service.CategoryService;

import com.codegym.service.UnitService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("warehouse-management")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private CategoryService categoryService;

    /**
     * @return get all product
     */
    @GetMapping("/listProducts")
    public ResponseEntity<Page<Product>> listProducts(Pageable pageable) {
        Page<Product> products = productService.findAllByDeleteFlagFalsePaging(pageable);
        return products.isEmpty() ? new ResponseEntity<Page<Product>>(HttpStatus.NO_CONTENT) : new ResponseEntity<Page<Product>>(products, HttpStatus.OK);

    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
        Product product = productService.findById(id);

        return product == null ? new ResponseEntity<Product>(HttpStatus.NOT_FOUND) : new ResponseEntity<Product>(product, HttpStatus.OK);

    }

    @PostMapping("/create_product")
    public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
        productService.save(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getProductId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * update product by id
     */
    @RequestMapping(value = "/update_product/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        Product currentProduct = productService.findById(id);
        if (currentProduct == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        currentProduct.setProductId(product.getProductId());
        currentProduct.setProductName(product.getProductName());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setExpiryDate(product.getExpiryDate());
        currentProduct.setQuantity(product.getQuantity());
        currentProduct.setCategory(product.getCategory());
        currentProduct.setBrand(product.getBrand());
        currentProduct.setUnit(product.getUnit());
        currentProduct.setInfor(product.getInfor());
        currentProduct.setImageUrl(product.getImageUrl());
        productService.save(currentProduct);
        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
    }

    /**
     * delete product by id
     */
    @RequestMapping(value = "/delete_product/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer id) {
        Product product = productService.findById(id);
        productService.remove(product);
        productService.save(product);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    /**
     *
     * @return get all category
     */
    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>> listAllCategory() {
        List<Category> categories = categoryService.findAll();
        return categories.isEmpty() ? new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    /**
     *
     * @return get all category
     */
    @GetMapping("/listUnit")
    public ResponseEntity<List<Unit>> listAllUnit() {
        List<Unit> units = unitService.findAll();
        return units.isEmpty() ? new ResponseEntity<List<Unit>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Unit>>(units, HttpStatus.OK);
    }

    /**
     *
     * @return get all brand by category order by brandName
     */
    @GetMapping("/listBrandByCategory/{id}")
    public ResponseEntity<List<Product>> listBrandByCategory(@PathVariable Integer id) {
        List<Product> brandNameList = productService.findByCategory_CategoryIdAndDeleteFlagIsFalse(id);
        return brandNameList == null ? new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND) : new ResponseEntity<List<Product>>(brandNameList, HttpStatus.OK);
    }

    /**
     *
     * @return get all product by category and brand include pageable
     */
    @GetMapping("/listProductByCategoryAndBrand/{categoryId}/{brandId}")
    public ResponseEntity<Page<Product>> listBrandByCategory(@PathVariable Integer categoryId, @PathVariable Integer brandId, Pageable pageable) {
        Page<Product> productsFilter = productService.findAllByCategory_CategoryIdAndBrand_IdAndDeleteFlagIsFalse(categoryId, brandId, pageable);
        return productsFilter == null ? new ResponseEntity<Page<Product>>(HttpStatus.NOT_FOUND) : new ResponseEntity<Page<Product>>(productsFilter, HttpStatus.OK);
    }

    /**
     *
     * @return get all product by category include pageable
     */
    @GetMapping("/listProductByCategory/{categoryId}")
    public ResponseEntity<Page<Product>> listBrandByCategory(@PathVariable Integer categoryId, Pageable pageable) {
        Page<Product> productsFilterByCategory = productService.findAllByCategory_CategoryIdAndDeleteFlagIsFalse(categoryId, pageable);
        return productsFilterByCategory == null ? new ResponseEntity<Page<Product>>(HttpStatus.NOT_FOUND) : new ResponseEntity<Page<Product>>(productsFilterByCategory, HttpStatus.OK);
    }

    /**
     *
     * hai them: get all product by category and delete flag is false
     */
    @GetMapping("/listProductByCategory/hai/{categoryId}")
    public ResponseEntity<List<Product>> listCakeCandy(@PathVariable int categoryId) {
        List<Product> products=productService.findAllProductByCategoryAndDeleteFlagIsFalse(categoryId);
        return products == null ? new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND) : new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

}
