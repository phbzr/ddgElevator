package com.ddg.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class ElevatorControlPanel {

    @Autowired
    private Elevator elevator;
    @Autowired
    private ElevatorMoving elevatorMoving;

    private int dest = -1; //конечная точка
    private TreeSet<Integer> localUp = new TreeSet<>(); //очередь вверх
    private TreeSet<Integer> localDown = new TreeSet<>();// очередь вниз

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
        если пункт назначения = текущему этажу
        удаляем из главное очереди, до распределения
        */
        if (dest == elevator.getCurrentFloor()) {
            queue.pollFirst();
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
        while (queue.size() == 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /*
        передаем новую очередь в метод
        */
        addDestination(queue);
    }
}
