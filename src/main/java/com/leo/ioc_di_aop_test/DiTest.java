package com.leo.ioc_di_aop_test;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class DiTest {
    /**1.Set注入**/
    //创建对象
    private People people;
    @Test
    public void DIBySetMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //1.获得所需类的Class对象（默认获得目标类的全类名和依赖类的全类命）
        String targetObjAllName = "com.leo.ioc_di_aop_test.People";
        String diObjAllName = "com.leo.ioc_di_aop_test.Phone";
        //获取目标类的Class对象
        Class targetClass = Class.forName(targetObjAllName);
        //获取依赖类的Class对象
        Class diClass = Class.forName(diObjAllName);

        //2.获得目标对象的set方法（默认获得需要注入的对象的变量名）
        String objName = new String("phone");
        objName = objName.substring(0,1).toUpperCase() + objName.substring(1,objName.length());
        Method setMethod = targetClass.getMethod("set" + objName,diClass);

        //3.获得依赖对象的实体并注入
        //获取依赖对象
        Object diObject = diClass.newInstance();
        //获取目标对象并注入依赖对象
        setMethod.setAccessible(true);  //设置反射权限
        //注意这一步给目标对象赋值实际上需要使用动态代理(jdkProxy代理或者CGLib代理),这里省略代理过程
        people = createInstance(targetObjAllName);
        setMethod.invoke(people, diObject);

        //4.测试结果
        people.getPhone().callTo();
    }

    /**2.constructor注入**/
    private People people2;
    @Test
    public void DIByConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //1.获得所需类的Class对象（默认获得目标类的全类名和依赖类的全类名）
        String targetObjAllName = "com.leo.ioc_di_aop_test.People";
        String diObjAllName = "com.leo.ioc_di_aop_test.Phone";
        //获取目标类的Class对象
        Class targetClass = Class.forName(targetObjAllName);
        //获取依赖类的Class对象
        Class diClass = Class.forName(diObjAllName);

        //2.获得依赖对象的实体并注入
        //获取依赖对象
        Phone diObject = createInstance(diObjAllName);

        //注意这一步给目标对象赋值实际上需要使用动态代理(jdkProxy代理或者CGLib代理),这里省略代理过程
        people2 = createInstance(targetObjAllName,new String(),new Integer(0),diObject);

        //3.测试结果
        people2.getPhone().callTo();
    }

    /**
     * 根据类的全类名来创建对象
     * @param classAllName  要创建的对象的类的全类名
     * @param args          创建对象使用的参数(不能为null,参数顺序与构造函数一致)
     * @param <T>           创建的对象的类型
     * @param <A>           创建对象时所用的参数的类型
     * @return
     */
    public static <T,A> T createInstance(String classAllName,A... args){
        Object obj = null;
        try {
            //获得相应的Class类的对象
            Class clz = Class.forName(classAllName);

            //判断是否需要无参构造函数
            if(args.length != 0){
                //获取参数相应的Class[]
                Class[] argsClass = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    argsClass[i] = args[i].getClass();
                }
                //获得构造方法对象
                Constructor constructor = clz.getDeclaredConstructor(argsClass);
                //使用newInstance创建对象
                obj = constructor.newInstance(args);
            }else{
                //获得构造方法对象
                Constructor constructor = clz.getDeclaredConstructor();
                //使用newInstance创建对象
                obj = constructor.newInstance();
            }
            //需要检查checkType是不是obj的字节码对象
            if (!clz.isInstance(obj)) {
                throw new Exception("对象跟字节码不兼容");
            }
            return (T)obj;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Date d1 = createInstance("java.util.Date");
        System.out.println(d1);
    }
}
