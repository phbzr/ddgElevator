package com.ddg.task.domain;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorDestination {
    private static Queue<Integer> waiters = new LinkedList<>();

    public ElevatorDestination() {
    }

    public static Queue<Integer> getWaiters() {
        return waiters;
    }

    public static void setWaiters(Queue<Integer> waiters) {
        ElevatorDestination.waiters = waiters;
    }


}
