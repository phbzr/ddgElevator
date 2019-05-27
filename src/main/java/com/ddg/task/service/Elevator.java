package com.ddg.task.service;

public class Elevator {
    private int currentFloor = 1;
    private String message;
    private String exitStatus;

    public Elevator() {
    }

    public void setExitStatus(String exitStatus) {
        this.exitStatus = exitStatus;
    }

    public String getExitStatus() {
        return exitStatus;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = Integer.toString(currentFloor);
    }
}
