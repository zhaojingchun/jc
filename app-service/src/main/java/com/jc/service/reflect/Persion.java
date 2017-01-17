package com.jc.service.reflect;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 17-1-17
 * Time: 下午1:58
 * To change this template use File | Settings | File Templates.
 */
public class Persion implements IPersion{
    private static  String name ;
    private Integer age;
    public  String Sex;

    public Persion(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public Persion() {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void sayHello() {
        System.out.print("hello word!!");
    }
}