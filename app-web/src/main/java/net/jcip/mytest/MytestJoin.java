package net.jcip.mytest;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 16-1-25
 * Time: 下午3:57
 * To change this template use File | Settings | File Templates.
 */
public class MytestJoin {
    public static void  main(String[] args){
        Thread1 thread1 = new Thread1("Thread1");
        Thread2 thread2 = new Thread2("Thread2", thread1);
        thread2.start();
    }

}

class Thread1 extends Thread
{
    public Thread1(String threadName){
        super(threadName);
    }

    public void run(){
        System.out.println(getName() + "is running");
        try{
            sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println(getName() + "end");
        }
    }
}


class Thread2 extends Thread
{
    private Thread1 thread1;

    public Thread2(String threadName, Thread1 thread1){
        super(threadName);
        this.thread1 = thread1;
    }

    public void run()
    {
        System.out.println(getName() +  "is running");
        try{
            thread1.start();
            thread1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("thread2 is over");
    }
}
