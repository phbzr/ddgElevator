package com.ddg.task.service;

import com.ddg.task.model.Elevator;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.TreeSet;

public class ElevatorControlPanel {

    @Autowired
    private Elevator elevator;
    @Autowired
    private ElevatorMoving elevatorMoving;

    private int dest = -1; //конечная точка
    private TreeSet<Integer> localUp = new TreeSet<>(); //очередь вверх
    private TreeSet<Integer> localDown = new TreeSet<>();// очередь вниз
    private final Object lock = new Object();

    public Object getLock() {
        return lock;
    }

    public TreeSet<Integer> getLocalUp() {
        return localUp;
    }

    public void setLocalUp(TreeSet<Integer> localUp) {
        this.localUp = localUp;
    }

    public void setLocalDown(TreeSet<Integer> localDown) {
        this.localDown = localDown;
    }

    public TreeSet<Integer> getLocalDown() {
        return localDown;
    }

    public ElevatorControlPanel() {
    }

    /*
     добавляем пункт назначения с очереди пунктов
    */

    public void addDestination(TreeSet<Integer> queue) {
        /*
        если очередь не пустая добавляем пункт назначаения с первого элемента в очереди
        */
        if (queue.size() > 0) {
            dest = queue.pollFirst();
        }
         /*
        проверяем пункт назначения(1-7 этаж)
        рапределяем по очередям вверх\вниз
        назначаем предыдущий этаж
        запускаем в работу
        */
        if (dest > 0 && dest < 8) {
            if (dest < elevator.getCurrentFloor()) {
                localDown.add(dest);
            }
            if (dest > elevator.getCurrentFloor()) {
                localUp.add(dest);
            }
            elevatorMoving.work();
        }
        /*
        ждем появления элементов в очереди
        */
        synchronized (lock) {
            if (queue.size() == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            addDestination(queue);
        }
    }
}
