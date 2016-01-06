package com.jc.dao;

import com.jc.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-10-9
 * Time: 上午10:42
 * To change this template use File | Settings | File Templates.
 */
public  interface FirstDao {
    public User getUserByid(Map map);
    int batchUpdate(List<Object> list);
}

