package com.ddg.task.controller;

import com.ddg.task.domain.ElevatorDestination;
import com.ddg.task.service.Elevator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ddg.task.domain.HelloWorldObject;

@RestController
public class RestControllerClass {


//    @PostMapping("/api/myrequest")
//    public ResponseEntity<Elevator> catchPostMapping(@RequestBody HelloWorldObject object){
//        System.out.println(object.getId());
//        Elevator responseObject = new Elevator();
//        responseObject.setDestination(object);
//        responseObject.setMessage("privet");
//        return new ResponseEntity<Elevator>(responseObject, HttpStatus.OK);
//    }

    @PostMapping("/api/myrequest")
    public String getDestination(@RequestBody HelloWorldObject object) {
        System.out.println("Rabotau");
        ElevatorDestination.getWaiters().add(object.getId());
        return "greeting";
    }

    @PostMapping("/api/light")
    public ResponseEntity<Elevator> catchPostMapping(@RequestBody HelloWorldObject object) {
        Elevator responseObject = new Elevator();
        responseObject.setMessage("privet");
        return new ResponseEntity<Elevator>(responseObject, HttpStatus.OK);
    }


}
