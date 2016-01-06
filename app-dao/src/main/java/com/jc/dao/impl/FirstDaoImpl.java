package com.jc.dao.impl;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.jc.dao.BaseDao;
import com.jc.dao.FirstDao;
import com.jc.domain.User;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.util.List;
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
    public int batchUpdate(final List<Object> list){
        int executeResult = (Integer)this.execute(new SqlMapClientCallback(){
            @Override
            public Integer doInSqlMapClient(SqlMapExecutor sqlMapExecutor) throws SQLException {
                int insertRows = 0; //影响行数
                sqlMapExecutor.startBatch();
                if (!CollectionUtils.isEmpty(list)) {
                    for (Object obj : list) {
                        sqlMapExecutor.insert("TeamSkuExtra.batchUpdateErpPromoId", obj);
                    }
                }
                insertRows = sqlMapExecutor.executeBatch();
                return new Integer(insertRows);
            }
        });
        return executeResult;
    }


}
