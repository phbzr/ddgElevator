package com.ddg.task.service;

import com.ddg.task.domain.ElevatorDestination;

import java.util.Queue;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class ElevatorControlPanel {
    private int last;
    private ElevatorMoving elv = new ElevatorMoving();
    public static TreeSet<Integer> localUp = new TreeSet<>(); //очередь вверх
    public static TreeSet<Integer> localDown = new TreeSet<>();


    public ElevatorControlPanel() {
    }

    public void addDestination(Queue<Integer> queue) {
        System.out.println("tyt");
        int dest = -1;
        if (ElevatorDestination.getWaiters().size() > 0) {
            dest = queue.poll();
            System.out.println(ElevatorDestination.getWaiters());
        }

        if (dest == Elevator.getCurrentFloor() || dest == last) {
            System.out.println(dest);
            System.out.println("надо ли 1 " + Elevator.getCurrentFloor());
            return;
        }

        if (dest > 0 && dest < 8) {
            if (dest < Elevator.getCurrentFloor()) {
                localDown.add(dest);
            }
            if (dest > Elevator.getCurrentFloor()) {
                localUp.add(dest);
            }
            last = dest;
            System.out.println(localUp.size() + " " + localDown.size());

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
