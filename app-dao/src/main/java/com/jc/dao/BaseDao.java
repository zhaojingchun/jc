package com.jc.dao;


import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-10-9
 * Time: 上午10:41
 * To change this template use File | Settings | File Templates.
 */
public class BaseDao  extends SqlMapClientTemplate {

    @Resource(name = "sqlMapClient")
    private SqlMapClient sqlMapClient;

    @PostConstruct
    public void initSqlMapClient(){
        super.setSqlMapClient(sqlMapClient);
    }
}