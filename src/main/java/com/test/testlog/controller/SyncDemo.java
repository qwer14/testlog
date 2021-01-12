package com.test.testlog.controller;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class SyncDemo {
    public synchronized void method() {
            System.out.println("synchronized");
    }

    private ReentrantLock lock = new ReentrantLock();
    public void modifyPublicResources(){
        try {
            lock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
