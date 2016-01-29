package net.jcip.mytest;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 16-1-29
 * Time: 下午3:20
 * To change this template use File | Settings | File Templates.
 */
public class Task implements Runnable
{
    @Override
    public void run()
    {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.parseInt("234"));
        System.out.println(Integer.parseInt("345"));
        System.out.println(Integer.parseInt("XYZ")); //This will cause NumberFormatException
        System.out.println(Integer.parseInt("456"));
    }

    public static void main(String[] args)
    {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();
    }
}

