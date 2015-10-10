package com.jc;

import com.jc.service.TestService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-9-30
 * Time: 下午2:51
 * To change this template use File | Settings | File Templates.
 */
public class TestAction extends ActionSupport {
    private static int  no = 0;
    private TestService testService;
    public void test1(){
        System.out.print("哈哈");
        System.out.print("hello word");
        no++;
        System.out.println(testService.getTest()+no);
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}
