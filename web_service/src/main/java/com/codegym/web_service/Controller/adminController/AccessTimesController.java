package com.codegym.web_service.Controller.adminController;

import com.codegym.dao.entity.AccessTimesDTO;
import com.codegym.dao.repository.AccessTimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class AccessTimesController {
    @Autowired
    AccessTimesRepository accessTimesRepository;

    @RequestMapping(value = "/access-times", method = RequestMethod.GET)
    public ResponseEntity<List<AccessTimesDTO>> avc() {
        List<AccessTimesDTO> localDateTimeIntegerMap = accessTimesRepository.countAccessTimes();
        for(int i =0;i<localDateTimeIntegerMap.size();i++){
            if(localDateTimeIntegerMap.size()>12){
                localDateTimeIntegerMap.remove(0);
            }else {
                break;
            }
        }
        if (localDateTimeIntegerMap.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(localDateTimeIntegerMap, HttpStatus.OK);
    }

    public static void main(String[] args) {

    }
}
