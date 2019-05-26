package com.ddg.task.service;


public class Elevator {
    private static int currentFloor = 1;
    private String message;
    private String exitStatus;
    private static String checker = "300";

    public static String getChecker() {
        return checker;
    }

    public static void setChecker(String checker) {
        Elevator.checker = checker;
    }

    public void setExitStatus(String exitStatus) {
        this.exitStatus = exitStatus;
    }

    public String getExitStatus() {
        return exitStatus;
    }

    public Elevator() {

    }

    public static int getCurrentFloor() {
        return currentFloor;
    }

    public static void setCurrentFloor(int currentFloor) {
        Elevator.currentFloor = currentFloor;
    }

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
