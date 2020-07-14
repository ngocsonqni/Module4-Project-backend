//package com.codegym.web_service.Controller.employeeController;
//import com.codegym.dao.entity.*;
//import com.codegym.service.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.util.List;
//@RestController
//public class BillController {
//    @Autowired
//    private StorageLocationService storageLocationService;
//    @Autowired
//    private TransportationService transportationService;
//    @Autowired
//    private TypeBillService typeBillService;
//    @Autowired
//    private WareHouseService wareHouseService;
//    @Autowired
//    private PayService payService;
//    @Autowired
//    private BillService billService;
//
//    //-------------------Find All StorageLocations--------------------------------------------------------
//
//    @RequestMapping(value = "/storageLocations/", method = RequestMethod.GET)
//    public ResponseEntity<List<StorageLocation>> listAllStorageLocations() {
//        List<StorageLocation> storageLocations = storageLocationService.findAll();
//        if (storageLocations.isEmpty()) {
//            return new ResponseEntity<List<StorageLocation>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<StorageLocation>>(storageLocations, HttpStatus.OK);
//    }
//    //-------------------Find Single StorageLocation--------------------------------------------------------
//
//    @RequestMapping(value = "/storageLocations/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<StorageLocation> getStorageLocation(@PathVariable("id") Integer id) {
//        System.out.println("Fetching StorageLocation with id " + id);
//        StorageLocation storageLocation = storageLocationService.findById(id);
//        if (storageLocation == null) {
//            System.out.println("StorageLocation with id " + id + " not found");
//            return new ResponseEntity<StorageLocation>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<StorageLocation>(storageLocation, HttpStatus.OK);
//    }
//    //-------------------Find All Transportations--------------------------------------------------------
//
//    @RequestMapping(value = "/transportations/", method = RequestMethod.GET)
//    public ResponseEntity<List<Transportation>> listAllTransportations() {
//        List<Transportation> transportation = transportationService.findAll();
//        if (transportation.isEmpty()) {
//            return new ResponseEntity<List<Transportation>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<Transportation>>(transportation, HttpStatus.OK);
//    }
//    //-------------------Find Single Transportation--------------------------------------------------------
//
//    @RequestMapping(value = "/transportations/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Transportation> getTransportation(@PathVariable("id") Integer id) {
//        System.out.println("Fetching Transportation with id " + id);
//        Transportation transportation = transportationService.findById(id);
//        if (transportation == null) {
//            System.out.println("Transportation with id " + id + " not found");
//            return new ResponseEntity<Transportation>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Transportation>(transportation, HttpStatus.OK);
//    }
//    //-------------------Find All TypeBills--------------------------------------------------------
//
//    @RequestMapping(value = "/typeBills/", method = RequestMethod.GET)
//    public ResponseEntity<List<TypeBill>> listAllTypeBills() {
//        List<TypeBill> typeBills = typeBillService.findAll();
//        if (typeBills.isEmpty()) {
//            return new ResponseEntity<List<TypeBill>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<TypeBill>>(typeBills, HttpStatus.OK);
//    }
//    //-------------------Find Single TypeBill--------------------------------------------------------
//
//    @RequestMapping(value = "/typeBills/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<TypeBill> getTypeBill(@PathVariable("id") Integer id) {
//        System.out.println("Fetching TypeBill with id " + id);
//        TypeBill typeBill = typeBillService.findById(id);
//        if (typeBill == null) {
//            System.out.println("TypeBill with id " + id + " not found");
//            return new ResponseEntity<TypeBill>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<TypeBill>(typeBill, HttpStatus.OK);
//    }
//    //-------------------Find All wareHouses--------------------------------------------------------
//
//    @RequestMapping(value = "/wareHouses/", method = RequestMethod.GET)
//    public ResponseEntity<List<WareHouse>> listAllWareHouses() {
//        List<WareHouse> wareHouses = wareHouseService.findAll();
//        if (wareHouses.isEmpty()) {
//            return new ResponseEntity<List<WareHouse>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<WareHouse>>(wareHouses, HttpStatus.OK);
//    }
//    //-------------------Find Single TypeBill--------------------------------------------------------
//
//    @RequestMapping(value = "/wareHouses/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<WareHouse> getWareHouse(@PathVariable("id") Integer id) {
//        System.out.println("Fetching WareHouse with id " + id);
//        WareHouse wareHouse = wareHouseService.findById(id);
//        if (wareHouse == null) {
//            System.out.println("WareHouse with id " + id + " not found");
//            return new ResponseEntity<WareHouse>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<WareHouse>(wareHouse, HttpStatus.OK);
//    }
//    //-------------------Find All Pays--------------------------------------------------------
//
//    @RequestMapping(value = "/pays/", method = RequestMethod.GET)
//    public ResponseEntity<List<Pay>> listAllPays() {
//        List<Pay> pays = payService.findAll();
//        if (pays.isEmpty()) {
//            return new ResponseEntity<List<Pay>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<Pay>>(pays, HttpStatus.OK);
//    }
//    //-------------------Find Single Pay--------------------------------------------------------
//
//    @RequestMapping(value = "/pays/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Pay> getPay(@PathVariable("id") Integer id) {
//        System.out.println("Fetching Pay with id " + id);
//        Pay pay = payService.findById(id);
//        if (pay == null) {
//            System.out.println("Pay with id " + id + " not found");
//            return new ResponseEntity<Pay>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Pay>(pay, HttpStatus.OK);
//    }
//
//
////-------------------Find All Bills--------------------------------------------------------
//
//    @RequestMapping(value = "/bills/", method = RequestMethod.GET)
//    public ResponseEntity<List<Bill>> listAllBills() {
//        List<Bill> bills = billService.findAllByDeleteFlagFalse();
//        if (bills.isEmpty()) {
//            return new ResponseEntity<List<Bill>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<Bill>>(bills, HttpStatus.OK);
//    }
//
//    //-------------------Retrieve Single Bill--------------------------------------------------------
//
//    @RequestMapping(value = "/bills/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Bill> getBill(@PathVariable("id") Integer id) {
//        System.out.println("Fetching Bill with id " + id);
//        Bill bill = billService.findById(id);
//        if (bill == null) {
//            System.out.println("Bill with id " + id + " not found");
//            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Bill>(bill, HttpStatus.OK);
//    }
//
//    //-------------------Create a Bill--------------------------------------------------------
//
////    @RequestMapping(value = "/bills/", method = RequestMethod.POST)
////    public ResponseEntity<Void> createBill(@RequestBody Bill Bill, UriComponentsBuilder ucBuilder) {
////        billService.save(bill);
////        HttpHeaders headers = new HttpHeaders();
////        headers.setLocation(ucBuilder.path("/products/{id}").buildAndExpand(product.getProductId()).toUri());
////        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
////    }
//
//    //------------------- Update a Product --------------------------------------------------------
////
////    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
////    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
////        System.out.println("Updating Product " + id);
////
////        Product currentProduct = productService.findById(id);
////
////        if (currentProduct == null) {
////            System.out.println("Product with id " + id + " not found");
////            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
////        }
////
////        currentProduct.setProductId(product.getProductId());
////        currentProduct.setProductName(product.getProductName());
////        currentProduct.setPrice(product.getPrice());
////        currentProduct.setExpiryDate(product.getExpiryDate());
////        currentProduct.setQuantity(product.getQuantity());
////        currentProduct.setCategory(product.getCategory());
////        currentProduct.setBrand(product.getBrand());
////        currentProduct.setUnit(product.getUnit());
////
////        productService.save(currentProduct);
////        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
////    }
//
//    //------------------- Delete a bill --------------------------------------------------------
//
//    @RequestMapping(value = "/products_delete/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Bill> deleteBill(@PathVariable("id") Integer id) {
//        Bill bill = billService.findById(id);
//
//        billService.remove(bill);
//        billService.save(bill);
//        return new ResponseEntity<Bill>(HttpStatus.OK);
//    }
//
//
//
//}
