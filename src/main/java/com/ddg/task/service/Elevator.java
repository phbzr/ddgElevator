package com.ddg.task.service;


public class Elevator {
    private static int currentFloor = 1;
    private String message;

    public Elevator() {

    }

    public static int getCurrentFloor() {
        return currentFloor;
    }

    public static void setCurrentFloor(int currentFloor) {
        Elevator.currentFloor = currentFloor;
    }

//    public void setDestination(HelloWorldObject object){
//        evc.addDestination(object.getId());
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = Integer.toString(currentFloor);
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "currentFloor=" + currentFloor +
                '}';
    }
}
