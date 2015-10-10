package test.com.jc.BaseTest;

import com.jc.TestAction;
import com.jc.dao.impl.FirstDaoImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-9-30
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
public class TestActionTest extends BaseTest {
    private FirstDaoImpl firstDao;
    private FirstDaoImpl readfirstDao;
    private TestAction testAction;

    @Test
    public void testTest(){
//        Map<String,Long> param = new HashMap<String,Long>();
//        param.put("id",1l);
//        firstDao.getUserByid(param);
//        readfirstDao.getUserByid(param);
        testAction.test1();
    }

    public TestAction getTestAction() {
        return testAction;
    }

    public void setTestAction(TestAction testAction) {
        this.testAction = testAction;
    }

    public void setFirstDao(FirstDaoImpl firstDao) {
        this.firstDao = firstDao;
    }

    public void setReadfirstDao(FirstDaoImpl readfirstDao) {
        this.readfirstDao = readfirstDao;
    }
}
