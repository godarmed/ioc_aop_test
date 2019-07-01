package com.leo.ioc_di_aop_test;

import org.junit.Test;

import java.util.Scanner;

/**
 * 多线程死锁测试
 */
public class SynchronizedTest1 {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();
    private static Integer test = 0;
    public static void main(String[] args) {
        deadLockTest1();
    }


    public static void deadLockTest1(){
        Thread t1 = new Thread(() ->{
           synchronized(resource1){
               System.out.println(Thread.currentThread() + "get resource1");
               try {
                   Thread.sleep(1000);
               }catch(InterruptedException e){
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread() + "waiting get resource2");
               synchronized(resource2){
                   System.out.println(Thread.currentThread() + "get resource2");
               }
           }
        },"线程1");
        t1.start();

        Thread t2 = new Thread(() ->{
            synchronized(resource2){
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");

                synchronized(resource1){
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        },"线程2");
        t2.start();
    }

    @Test
    public void test(){
        System.out.println(SynchronizedTest1.test++);

    }

}
