package com.ddg.task.controller;

import com.ddg.task.service.ElevatorControlPanel;
import com.ddg.task.service.ElevatorDestination;
import com.ddg.task.domain.ElevatorStatus;
import com.ddg.task.service.ElevatorState;
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
    private ElevatorState elevatorState;

    @Autowired
    private ElevatorControlPanel elevatorControlPanel;
    /*
        Получаем пункт назначения
    */
    @PostMapping("/api/destination")
    public void getDestination(@RequestBody ResponseObject object) {

        elevatorDestination.getWaiters().add(object.getId());
        synchronized (elevatorControlPanel.getLock()) {
            elevatorControlPanel.getLock().notify();
        }
    }
    /*
        Отдаем текущий этаж
        и статус остановки
    */
    @PostMapping("/api/light")
    public ResponseEntity<ElevatorState> currentFloorStatus() {
        elevatorState.setMessage("");
        elevatorState.setExitStatus(elevatorStatus.getChecker());
        return new ResponseEntity<>(elevatorState, HttpStatus.OK);
    }

}
