package com.ddg.task.service;

import java.util.TreeSet;
import java.util.concurrent.TimeUnit;


public class ElevatorMoving {

    public void work() {

        if ((Elevator.getCurrentFloor() == 1 || ElevatorControlPanel.localDown.size() == 0) && ElevatorControlPanel.localUp.size() > 0) {
            while (ElevatorControlPanel.localUp.size() > 0) {
                elevatorUp(ElevatorControlPanel.localUp);
            }
        } else if (Elevator.getCurrentFloor() > 1 && ElevatorControlPanel.localDown.size() > 0) {

            while (ElevatorControlPanel.localDown.size() > 0) {
                elevatorDown(ElevatorControlPanel.localDown);
            }
        }

    }

    private void elevatorDown(TreeSet<Integer> local) {
        //wait after
        while (Elevator.getCurrentFloor() != local.last() && Elevator.getCurrentFloor() < 8 && Elevator.getCurrentFloor() > 0) {
            System.out.println("Текущий этаж: " + Elevator.getCurrentFloor());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int x = Elevator.getCurrentFloor();
            x--;
            Elevator.setCurrentFloor(x);
        }
        //wait before
        Elevator.setCurrentFloor(Elevator.getCurrentFloor());
        System.out.println("Прибыли на " + Elevator.getCurrentFloor());
        local.pollLast();
    }

    private void elevatorUp(TreeSet<Integer> local) {
        //wait after
        while (Elevator.getCurrentFloor() != local.first() && Elevator.getCurrentFloor() < 8 && Elevator.getCurrentFloor() > 0) {

            System.out.println("Текущий этаж: " + Elevator.getCurrentFloor());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int x = Elevator.getCurrentFloor();
            x++;
            Elevator.setCurrentFloor(x);

        }
        //wait before
        Elevator.setCurrentFloor(Elevator.getCurrentFloor());
        System.out.println("Прибыли на " + Elevator.getCurrentFloor());
        local.pollLast();
    }

}
