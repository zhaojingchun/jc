package com.jc.dao.impl;

import com.jc.dao.BaseDao;
import com.jc.dao.FirstDao;
import com.jc.domain.User;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-10-9
 * Time: 上午10:42
 * To change this template use File | Settings | File Templates.
 */
public class FirstDaoImpl extends BaseDao implements FirstDao {
    public User getUserByid(Map map){
        return (User) queryForObject("First.getUserById",map);
    }
}
