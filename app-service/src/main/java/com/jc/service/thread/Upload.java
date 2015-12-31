package com.jc.service.thread;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-12-31
 * Time: 下午4:14
 * To change this template use File | Settings | File Templates.
 */
public abstract class Upload {
    protected String info;
    abstract boolean uploadPic();
    public String getInfo(){
        return info;
    }
}
