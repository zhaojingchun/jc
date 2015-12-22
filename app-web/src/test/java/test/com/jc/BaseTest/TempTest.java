package test.com.jc.BaseTest;

import org.json.JSONObject;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-11-6
 * Time: 上午10:07
 * To change this template use File | Settings | File Templates.
 */
public class TempTest {
    @Test
    public void test(){
        String str = "{\\\"response\\\":{\\\"categories\\\":[{\\\"id\\\":25,\\\"name\\\":\\\"北京\\\",\\\"letter\\\":\\\"B\\\",\\\"sortOrder\\\":99999,\\\"feature\\\":1,\\\"ename\\\":\\\"beijing\\\"},{\\\"id\\\":34,\\\"name\\\":\\\"上海\\\",\\\"letter\\\":\\\"S\\\",\\\"sortOrder\\\":9999,\\\"feature\\\":1,\\\"ename\\\":\\\"shanghai\\\"}],\\\"resultCode\\\":\\\"200\\\"}}";
        String str1 =   getObjFromJsonArrStr(str);
        System.out.print("");
    }

    /**
     * 由字符串反序列化成实体类  针对的是一个实体，此实体中的属性不包括自定义的类型，如Teacher类型，或者List<Teacher>类型
     * @param source 传入json中的字符串
     * @param beanClass 实体类的类型
     * @return 实体类
     */
    public static String getObjFromJsonArrStr(String source)
    {
        String stu = "";
        JSONObject jsonObject = new JSONObject();
        try{
            stu =  jsonObject.getString(source);
        }catch (Exception e){

        }
        return stu;
    }

    @Test
    public void booleanTest(){
       Boolean bool = Boolean.FALSE;
        boolA(bool);
        System.out.print(bool);

    }

    public void boolA(Boolean bool){
        bool=Boolean.TRUE;
        System.out.print(bool);
    }
}
