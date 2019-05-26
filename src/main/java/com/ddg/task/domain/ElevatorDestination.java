package com.ddg.task.domain;

import java.util.TreeSet;

public class ElevatorDestination {
    private static TreeSet<Integer> waiters = new TreeSet<>();

    public ElevatorDestination() {
    }

    public static TreeSet<Integer> getWaiters() {
        return waiters;
    }

    public static void setWaiters(TreeSet<Integer> waiters) {
        ElevatorDestination.waiters = waiters;
    }


}
