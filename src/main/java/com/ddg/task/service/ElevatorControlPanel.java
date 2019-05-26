package com.ddg.task.service;

import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class ElevatorControlPanel {
    private int last;
    private ElevatorMoving elv = new ElevatorMoving();
    public static TreeSet<Integer> localUp = new TreeSet<>(); //очередь вверх
    public static TreeSet<Integer> localDown = new TreeSet<>();


    public ElevatorControlPanel() {
    }

    public void addDestination(TreeSet<Integer> queue) {


        int dest = -1;
        if (queue.size() > 0) {
            dest = queue.pollFirst();
        }

        if (dest == Elevator.getCurrentFloor() || dest == last) {
            Elevator.setChecker("500");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.pollFirst();
            Elevator.setChecker("300");
        }

        if (dest > 0 && dest < 8) {
            if (dest < Elevator.getCurrentFloor()) {
                localDown.add(dest);
            }
            if (dest > Elevator.getCurrentFloor()) {
                localUp.add(dest);
            }
            last = dest;
            elv.work();
        }
        while (queue.size() == 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        addDestination(queue);
    }
}
