package net.jcip.examples;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.*;


/**
 * LogService
 * <p/>
 * Adding reliable cancellation to LogWriter
 *
 * @author Brian Goetz and Tim Peierls
 */
public class LogService {
    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;
    private final PrintWriter writer;
    private boolean isShutdown;
    private int reservations;

    public LogService(Writer writer) {
        this.queue = new LinkedBlockingQueue<String>();
        this.loggerThread = new LoggerThread();
        this.writer = new PrintWriter(writer);
    }

    public void start() {
        loggerThread.start();
    }

    /**
     * 停止线程
     * 并请求终端线程
     */
    public void stop() {
        synchronized (this) {
            isShutdown = true;
        }
        loggerThread.interrupt();
    }

    /**
     * 如果线程关闭了，报异常
     * 否则数量+1
     * @param msg
     * @throws InterruptedException
     */
    public void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutdown)
                throw new IllegalStateException(/*...*/);
            ++reservations;
        }
        queue.put(msg);
    }

    /**
     * 如果关闭了loger线程
     * 并且没有线程需要些
     * 线程结束
     */
    private class LoggerThread extends Thread {
        public void run() {
            try {
                while (true) {
                    try {
                        synchronized (LogService.this) {
                            if (isShutdown && reservations == 0)
                                break;
                        }
                        String msg = queue.take();
                        synchronized (LogService.this) {
                            --reservations;
                        }
                        writer.println(msg);
                    } catch (InterruptedException e) { /* retry */
                    }
                }
            } finally {
                writer.close();
            }
        }
    }
}

