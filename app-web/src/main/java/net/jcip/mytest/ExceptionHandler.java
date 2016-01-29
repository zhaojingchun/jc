package net.jcip.mytest;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 16-1-29
 * Time: 下午3:23
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler
{
    public void uncaughtException(Thread t, Throwable e)
    {
        System.out.printf("An exception has been capturedn");
        System.out.printf("Thread: %sn", t.getId());
        System.out.printf("Exception: %s: %sn", e.getClass().getName(), e.getMessage());
        System.out.printf("Stack Trace: n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %sn", t.getState());
        new Thread(new Task()).start();
    }
}