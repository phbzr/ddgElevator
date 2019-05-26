package com.ddg.task.service;

import com.ddg.task.domain.ElevatorDestination;

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
        try {
            while (Elevator.getCurrentFloor() != local.last() && Elevator.getCurrentFloor() < 8 && Elevator.getCurrentFloor() > 0) {
                if (ElevatorDestination.getWaiters().contains(Elevator.getCurrentFloor())) {
                    exitSender();
                    ElevatorDestination.getWaiters().remove(Elevator.getCurrentFloor());
                }
                System.out.println("Текущий этаж: " + Elevator.getCurrentFloor());
                TimeUnit.SECONDS.sleep(9);

                int x = Elevator.getCurrentFloor();
                x--;
                Elevator.setCurrentFloor(x);
            }

            Elevator.setCurrentFloor(Elevator.getCurrentFloor());
            exitSender();
            local.pollLast();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void elevatorUp(TreeSet<Integer> local) {
        try {
            while (Elevator.getCurrentFloor() != local.first() && Elevator.getCurrentFloor() < 8 && Elevator.getCurrentFloor() > 0) {

                if (ElevatorDestination.getWaiters().contains(Elevator.getCurrentFloor())) {
                    exitSender();
                    ElevatorDestination.getWaiters().remove(Elevator.getCurrentFloor());
                }

                System.out.println("Текущий этаж: " + Elevator.getCurrentFloor());
                TimeUnit.SECONDS.sleep(9);
                int x = Elevator.getCurrentFloor();
                x++;
                Elevator.setCurrentFloor(x);

            }

            Elevator.setCurrentFloor(Elevator.getCurrentFloor());
            exitSender();
            local.pollLast();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void exitSender() throws InterruptedException {
        Elevator.setChecker("500");
        System.out.println("Прибыли на " + Elevator.getCurrentFloor());
        TimeUnit.SECONDS.sleep(4);
        Elevator.setChecker("300");
    }

}
