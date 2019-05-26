package com.ddg.task.controller;

import com.ddg.task.domain.ElevatorDestination;
import com.ddg.task.service.Elevator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ddg.task.domain.ResponseObject;

@RestController
public class RestControllerClass {

    //Получаем пункт назначения
    @PostMapping("/api/myrequest")
    public void getDestination(@RequestBody ResponseObject object) {
        ElevatorDestination.getWaiters().add(object.getId());
    }
    //Отдаем текущий этаж
    @PostMapping("/api/light")
    public ResponseEntity<Elevator> currentFloorStatus(@RequestBody ResponseObject object) {
        Elevator responseObject = new Elevator();
        responseObject.setMessage("");
        responseObject.setExitStatus(Elevator.getChecker());
        return new ResponseEntity<Elevator>(responseObject, HttpStatus.OK);
    }

}
