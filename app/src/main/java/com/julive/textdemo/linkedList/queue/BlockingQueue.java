package com.julive.textdemo.linkedList.queue;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jinxianlun
 * on 11/10/21
 */
public class BlockingQueue {
    Object[] data;
    int takeIndex;
    int putIndex;
    int size;
    int limit;
    ReentrantLock lock = new ReentrantLock();
    Condition write;
    Condition read;

    public BlockingQueue(int capacity) {
        this.limit = capacity;
        data = new Object[limit];
        write = lock.newCondition();
        read = lock.newCondition();
    }

    public boolean put(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        try {
            lock.lock();
            while (size == limit) {
                //队列满了
                write.await();
            }
            data[putIndex++] = obj;
            if (putIndex == limit) {
                putIndex = 0;
            }
            size++;
            read.signal();
            return true;
        } catch (Exception e) {
            read.signal();
        } finally {
            lock.unlock();
        }
        return false;
    }

    public Object take() {
        try {
            lock.lock();
            while (size == 0) {
                //没数据了
                read.await();
            }
            Object res = data[takeIndex++];
            if (takeIndex == limit) {
                takeIndex = 0;
            }
            size--;
            write.signal();
            return res;
        } catch (Exception e) {
            write.signal();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        Random random = new Random(100);
        BlockingQueue yzBlockingQuery = new BlockingQueue(5);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                yzBlockingQuery.put(i);
                System.out.println("生产者生产了：" + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Object take = yzBlockingQuery.take();
                System.out.println("消费者消费了：" + take);
            }
        });

        thread1.start();
        thread2.start();
    }
}
