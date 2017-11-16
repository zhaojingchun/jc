package com.jc.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojingchun on 2017/11/16.
 */
public class Chain {
    private List<Handler> handlerList = new ArrayList();
    private int start = 0;
    public void proceed(){
        while(start<handlerList.size()){
            handlerList.get(start++).proceed(this);
        }
    }
    public void addHandler(Handler handler){
        handlerList.add(handler);
    }
}
