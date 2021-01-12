package com.test.testlog.controller;

public class Test {
    private static Object resourseA = new Object();
    private static Object resourseB = new Object();
    public static void main(String[] args) {
        new Thread( () -> {
            synchronized (resourseA){
                System.out.println(Thread.currentThread()+"拿到了A");
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread()+"等待去拿B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourseB){
                    System.out.println(Thread.currentThread()+"拿到了B");
                }
            }
        },"线程1").start();

        new Thread( () -> {
            synchronized (resourseB){
                System.out.println(Thread.currentThread()+"拿到了B");
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread()+"等待去拿A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourseA){
                    System.out.println(Thread.currentThread()+"拿到了A");
                }
            }
        },"线程2").start();
    }
}
