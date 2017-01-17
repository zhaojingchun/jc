package com.jc.service.reflect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 17-1-17
 * Time: 上午11:27
 * To change this template use File | Settings | File Templates.
 */
public class Reflect {
    private static final Log log = LogFactory.getLog(Reflect.class);

    // 通过无参构造函数实例化
    //方法要是public的否则报 NoSuchMethodException
    public  void instanceClassByConstrant() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Persion> defaultConstructor = Persion.class.getConstructor();
        defaultConstructor.newInstance();
        Constructor<Persion> constructor =  Persion.class.getConstructor(String.class,Integer.class);
        Persion persion = constructor.newInstance("dahui",18);
        log.info(persion);
    }

    //通过一个对象获得完整的包名和类名
    public static void printClassNamePackage(Class clazz){
        String str = String.format("包路径为：%s 类名为：%s",clazz.getPackage().toString(),clazz.getSimpleName().toString());
        log.info(str);
    }
    //实例化Class类对象
    public static<T> void instanceClass(Class<T> clazz) throws IllegalAccessException, InstantiationException {
         T obj =  clazz.newInstance();
    }

    public static void getImplInterface() throws IllegalAccessException, InstantiationException {
//       Class[] clazzes =  Persion.class.getInterfaces();
//        for(int i=0;i<clazzes.length;i++){
//            System.out.println(clazzes[i].getName());
//        }
//        Constructor[] cons =  Persion.class.getConstructors()    ;
//        for(int i=0;i<cons.length;i++){
//            System.out.println(cons[i]);
//        }
//        List<? extends Persion> listExtends = new ArrayList<Student>();
//        List<? super Student> listSuper = new ArrayList<Student>();
//        listSuper.add(new Student());
//        ((Student)listSuper.get(0)).sayHello();

        Field[] fields = Persion.class.getDeclaredFields();
        Object persion = Persion.class.newInstance();
        for(int i=0;i<fields.length;i++){
            fields[i].toString();
            fields[i].getName();
            fields[i].getType().getSimpleName();
            fields[i].getGenericType();
            Modifier.toString(fields[i].getModifiers());
            fields[2].set(persion,"dahui");
            System.out.println(fields[i]);
        }
    }

    public static void main(String[] args){

        try {
            getImplInterface();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
//        try {
//            new Reflect().instanceClassByConstrant();
//        } catch (Exception e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//        new Persion();
//        Reflect reflect = new Reflect();
//        reflect.printClassNamePackage(ThreadPoolManager.class);
    }
}
