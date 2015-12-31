package com.jc.service.thread;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-12-31
 * Time: 下午5:10
 * To change this template use File | Settings | File Templates.
 */
public class TaskUpload extends Upload{

    public TaskUpload(String info){
        this.info = info;
    }
    public String getInfo(){
        return info;
    }
    @Override
    public boolean uploadPic()  {
        System.out.println(info+"sleep begin ....");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(info+"sleep end ....");
        return false;
    }
}
