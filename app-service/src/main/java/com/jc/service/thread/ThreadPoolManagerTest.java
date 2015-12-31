package com.jc.service.thread;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-12-31
 * Time: 下午5:20
 * To change this template use File | Settings | File Templates.
 */
public class ThreadPoolManagerTest {

    public static void main(String[] args) {
        Upload[] tasks = createBatchTask(7);
        ThreadPoolManager pool = ThreadPoolManager.getInstance();
        pool.BatchAddTask(tasks);
        pool.destory();
    }
    private static Upload[] createBatchTask(int n){
        Upload[] tasks = new TaskUpload[n];
        for(int i = 0;i<n ;i++ ){
            tasks[i] = new TaskUpload("task id is "+ i);
        }
        return tasks;
    }
}
