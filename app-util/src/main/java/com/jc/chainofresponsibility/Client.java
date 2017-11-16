package com.jc.chainofresponsibility;

/**
 * Created by zhaojingchun on 2017/11/16.
 */
public class Client {

    public static void main(String[] args){
        Chain chain = new Chain();
        Handler handlerA = new Handler() {
            @Override
            public void execute() {
                System.out.println("====a======");
            }
        };
        Handler handlerB = new Handler() {
            @Override
            public void execute() {
                System.out.println("=====b====");
            }
        };
        Handler handlerC = new Handler() {
            @Override
            public void execute() {
                System.out.println("======C======");
            }
        };
        chain.addHandler(handlerA);
        chain.addHandler(handlerB);
        chain.addHandler(handlerC);
        chain.proceed();
    }
}
