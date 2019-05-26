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
    //Получаем пункт назначения
    @PostMapping("/api/myrequest")
    public String getDestination(@RequestBody HelloWorldObject object) {
        System.out.println("Rabotau");
        ElevatorDestination.getWaiters().add(object.getId());
        return "greeting";
    }
    //Отдаем текущий этаж
    @PostMapping("/api/light")
    public ResponseEntity<Elevator> currentFloorStatus(@RequestBody HelloWorldObject object) {
        Elevator responseObject = new Elevator();
        responseObject.setMessage("");
        responseObject.setExitStatus(Elevator.getChecker());
        return new ResponseEntity<Elevator>(responseObject, HttpStatus.OK);
    }

}
