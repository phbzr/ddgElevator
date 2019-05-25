package com.ddg.task.domain;


import java.util.LinkedList;
import java.util.Queue;

public class ElevatorDestination {
    private static Queue<Integer> waiters = new LinkedList<>();

    public static Queue<Integer> getWaiters() {
        System.out.println(waiters);
        return waiters;
    }

    public static void setWaiters(Queue<Integer> waiters) {
        ElevatorDestination.waiters = waiters;
    }


}
