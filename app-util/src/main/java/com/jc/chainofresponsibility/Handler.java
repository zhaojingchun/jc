package com.jc.chainofresponsibility;

/**
 * Created by zhaojingchun on 2017/11/16.
 */
public abstract class Handler {

    public void proceed(Chain chain){
        execute();
        chain.proceed();
    }

    public abstract void execute();


}
