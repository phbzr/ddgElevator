package com.ddg.task.controller;

import com.ddg.task.service.ElevatorDestination;
import com.ddg.task.service.Elevator;
import com.ddg.task.domain.ElevatorStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ddg.task.domain.ResponseObject;

@RestController
public class RestControllerClass {
    @Autowired
    private ElevatorDestination elevatorDestination;

    @Autowired
    private ElevatorStatus elevatorStatus;

    @Autowired
    private Elevator elevator;


    /*
        Получаем пункт назначения
    */
    @PostMapping("/api/myrequest")
    public void getDestination(@RequestBody ResponseObject object) {
        elevatorDestination.getWaiters().add(object.getId());
    }
    /*
        Отдаем текущий этаж
        и статус остановки
    */
    @PostMapping("/api/light")
    public ResponseEntity<Elevator> currentFloorStatus() {
        elevator.setMessage("");
        elevator.setExitStatus(elevatorStatus.getChecker());
        return new ResponseEntity<Elevator>(elevator, HttpStatus.OK);
    }

}
