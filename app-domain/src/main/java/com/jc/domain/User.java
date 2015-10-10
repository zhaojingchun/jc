package com.jc.domain;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-10-9
 * Time: 上午10:43
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private long userId;
    private String userName;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
