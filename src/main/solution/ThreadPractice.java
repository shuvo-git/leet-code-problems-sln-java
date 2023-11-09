package main.solution;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 11/9/2023
 * @time: 11:23 AM
 */

class Queue {
    int n = 0;
    boolean valueSet = false;

    public synchronized int getN() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        valueSet = false;
        notify();
        return n;
    }

    public synchronized void putN(int n) {
        while (valueSet){
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }}
        this.n = n;
        valueSet = true;
        notify();
    }
}

class Producer implements Runnable {
    Queue q;

    public Producer(Queue q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("Producing from Thread " + Thread.currentThread().getName() + ": " + ++i);

            q.putN(i);
        }
    }
}

class Consumer implements Runnable {
    Queue q;

    public Consumer(Queue q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Consuming from Thread " + Thread.currentThread().getName() + ": " + q.getN());
        }
    }
}

public class ThreadPractice {
    public static void main(String[] args) throws InterruptedException {
        Queue queue = new Queue();
        new Producer(queue);
        new Consumer(queue);
    }
}
