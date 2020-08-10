package com.codegym.web_service.Controller.employeeController;

import com.codegym.dao.entity.Bill;
import com.codegym.dao.entity.Distributor;
import com.codegym.dao.entity.TypeOfDistributor;
import com.codegym.service.BillService;
import com.codegym.service.DistributorService;
import com.codegym.service.TypeOfDistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DistributorController {
    @Autowired
    private TypeOfDistributorService typeOfDistributorService;
    @Autowired
    private DistributorService distributorService;
    @Autowired
    private BillService billService;

    @GetMapping("/distributor/{id}")
    public ResponseEntity<Distributor> findByID(@PathVariable Integer id) {
        System.out.println(id);
        Distributor distributor = this.distributorService.findById(id);
        if (distributor == null) {
            return new ResponseEntity<Distributor>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Distributor>(distributor, HttpStatus.OK);
    }

    @PostMapping("/distributor")
    public void save(@RequestBody Distributor distributor) {
        this.distributorService.save(distributor);
    }

    @GetMapping("/type_distributor/{name}")
    public TypeOfDistributor findByName(@PathVariable String name) {
        return this.typeOfDistributorService.findByName(name);
    }

    //Show List
//    @GetMapping("/distributor/list")
//    public ResponseEntity<List<Distributor>> listDistributors(){
//        List<Distributor> distributors  = distributorService.findAll();
//        if (distributors == null){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(distributors, HttpStatus.OK);
//    }
    //Create distributor
    @PostMapping("/distributor/create")
    public ResponseEntity<Distributor> createDistributor(@RequestBody Distributor distributor) {
        distributorService.save(distributor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Show list ,paging and sorting
    @GetMapping(value = "/distributor/list", params = {"page", "size", "search"})
    public ResponseEntity<Page<Distributor>> getAll(@RequestParam("page") int page,
                                                    @RequestParam("size") int size,
                                                    @RequestParam("search") String search) {
        Page<Distributor> distributorPage = distributorService.pageFindAllSearchName(PageRequest.of(page, size), search);
        if (distributorPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(distributorPage, HttpStatus.OK);
    }

    @GetMapping("/distributor/delete/{id}")
    public ResponseEntity<String> deleteALl(@PathVariable int id) {
        System.out.println("id cua no ne" + id);
        this.distributorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/distributor/deleteAll")
    public ResponseEntity<List<Distributor>> deleteALl(@RequestBody int[] deleteIdList) {
        List<Bill> bills;
        List<Distributor> deleteIdListFail = new ArrayList<Distributor>();
        Distributor distributor;
        for (int item : deleteIdList) {
            distributor = this.distributorService.findByIdToDo(item);
            if (distributor != null) {
                bills = this.billService.findAllByIdDistributorAndShippingStatusIsNot(distributor, "đã vận chuyển");
                if (bills.size() > 0) {
                    deleteIdListFail.add(distributor);
                } else {
                    this.distributorService.deleteById(item);
                }
            } else {
                distributor = this.distributorService.findById(item);
                deleteIdListFail.add(distributor);

            }

        }
        return new ResponseEntity<List<Distributor>>(deleteIdListFail, HttpStatus.OK);
    }

    @GetMapping("/distributor/exist/{name}/{id}")
    public ResponseEntity<Distributor> findByIsExistName(@PathVariable String name, @PathVariable int id) {
        Distributor distributor = this.distributorService.isExistDistributor(name, id);
        if (distributor != null) {
            return new ResponseEntity<Distributor>(distributor, HttpStatus.OK);
        } else {
            return new ResponseEntity<Distributor>(distributor, HttpStatus.NOT_FOUND);
        }

    }


//    @GetMapping("/distributor/setSession/{id}")
//    public void resetStatus(@PathVariable int id){
//        System.out.println(id);
//        Date date = new Date(System.currentTimeMillis()+10);
//        this.distributorService.resetStatusDistributor(id);
//    }

    @GetMapping("/distributorToDo/{id}/{status}")
    public ResponseEntity<Distributor> findByIDToDo(@PathVariable int id, @PathVariable int status) {
        Distributor distributor = this.distributorService.findByIdToDo(id);
        if (distributor != null) {
            this.distributorService.setStatusDistributor(id, status);
            this.distributorService.resetSession(id);
            return new ResponseEntity<>(distributor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

    }

    @GetMapping("/distributorToDoReset/{id}")
    public void resetStatusDistributorDefault(@PathVariable int id) {
        this.distributorService.dropEventById(id);
        this.distributorService.setStatusDistributor(id, 0);

    }


}
