package com.xianC;

import java.util.LinkedList;
import java.util.Scanner;

public class ProduceConsum {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        int size = 10;
        Produce produce = new Produce(linkedList, size);
        Consumer consumer = new Consumer(linkedList, size);
        Thread th1 = new Thread(produce);
        Thread th2 = new Thread(consumer);
        th1.start();
        th2.start();
    }
}


class Produce implements Runnable {
    private LinkedList<Integer> linkedList = new LinkedList<Integer>();
    private int size;

    public Produce(LinkedList linkedList, int size) {
        this.linkedList = linkedList;
        this.size = size;
    }


    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                synchronized (linkedList) {//共享
                    while (linkedList.size() == size) {
                        linkedList.wait();
                    }

                    linkedList.addLast(i);
                    System.out.println("生产者生产了" + i);

                    linkedList.notifyAll();//通知启动消费者
                }
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Consumer implements Runnable {
    private LinkedList<Integer> linkedList = new LinkedList<Integer>();
    private int size;

    public Consumer(LinkedList linkedList, int size) {
        this.linkedList = linkedList;
        this.size = size;
    }

    public void run() {
        while (true) {
            try {
                synchronized (linkedList) {
                    while (linkedList.size() == 0) {
                        linkedList.wait();
                    }

                    int value = linkedList.removeFirst();
                    System.out.println("消费者使用了" + value);

                    linkedList.notifyAll();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
