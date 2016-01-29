package net.jcip.mytest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 16-1-29
 * Time: 下午4:34
 * To change this template use File | Settings | File Templates.
 */
public class Pay {

    public static void main(String [] args){
        JCRunable runable = new  JCRunable();
        Thread t1 = new Thread(runable);
        Thread t2 = new Thread(runable);
        t1.start();t2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        t1.interrupt();
//        t2.interrupt();
    }

}

class JCThread1 extends Thread{
    @Override
    public void run() {
        try {
            while(!isInterrupted()){
                synchronized (Pay.class){
                    Pay.class.notify();
                    super.run();
                    System.out.println("Love 1");
                    Pay.class.wait();
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class JCThread2 extends Thread{
    @Override
    public void run() {
        try {
            while (!isInterrupted()){
                synchronized (Pay.class){
                    Pay.class.notify();
                    super.run();
                    System.out.println("Love 2");
                    Pay.class.wait();
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class JCRunable implements Runnable{
    private AtomicInteger atomic = new AtomicInteger();
    private AtomicInteger atomicNo = new AtomicInteger();

    @Override
    public void run() {
        String threadName = new StringBuilder().append("out------>Thread").append(atomic.incrementAndGet()).toString();
        synchronized (Pay.class){
        while(atomicNo.getAndIncrement()<100){
            try{
                Pay.class.notify();
                System.out.println(threadName+"   "+atomicNo.get());
                Pay.class.wait();
            }catch (Exception e){
            }
        }
        }
    }
}




