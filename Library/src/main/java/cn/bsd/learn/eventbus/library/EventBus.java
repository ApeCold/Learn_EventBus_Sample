package cn.bsd.learn.eventbus.library;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.bsd.learn.eventbus.library.annotation.Subscribe;

public class EventBus {
    private static volatile EventBus instance;
    //用来保存带注解方法（订阅方法）,key A or F
    private Map<Object, List<MethodManager>> cacheMap;

    private EventBus(){
        cacheMap = new HashMap<>();
    }

    public static EventBus getDefault() {
        if(instance==null){
            synchronized (EventBus.class){
                if (instance==null) {
                    instance = new EventBus();
                }
            }
        }
        return instance;
    }

    //收到信息方法
    //找到MainActivity所有带符合注解的方法
    public void register(Object getter){
        List<MethodManager> methodList = cacheMap.get(getter);
        if(methodList ==null){
            methodList = findAnnotationMethod(getter);
            cacheMap.put(getter,methodList);
        }
    }

    private List<MethodManager> findAnnotationMethod(Object getter) {
        List<MethodManager> methodList = new ArrayList<>();
        Class<?> clazz = getter.getClass();

        //获取MainActivity中所有的方法
        Method[] methods = clazz.getMethods();
//        Method[] declaredMethods = clazz.getDeclaredMethods();

        while (clazz!=null){
            String clazzName = clazz.getName();
            if(clazzName.startsWith("java.") ||clazzName.startsWith("javax.") ||clazzName.startsWith("android.")){
                break;
            }
            for (Method method : methods) {
                Subscribe subscribe = method.getAnnotation(Subscribe.class);
                if (subscribe==null){
                    continue;
                }

                //方法上的校验
                //获取方法的返回值
                Type returnType = method.getGenericReturnType();
                if(!"void".equals(returnType.toString())){
                    throw new RuntimeException(method.getName()+"方法返回值必须是void");
                }

                //方法参数有且只有一个
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length!=1) {
                    throw new RuntimeException(method.getName()+"方法参数有且只有一个");
                }

                //完全符合要求类
                MethodManager manager = new MethodManager(parameterTypes[0],subscribe.threadMode(),method);
                methodList.add(manager);
            }
            //不断循环找出父类含有订阅方法，直至为空
            clazz = clazz.getSuperclass();
        }

        return methodList;
    }

    //发送动作，发布事件
    public void post(Object setter) {
        Set<Object> set = cacheMap.keySet();
        //获取MainActivity对象
        for (Object getter : set) {
            //获取MainActivity中所有带注解的方法
            List<MethodManager> methodList = cacheMap.get(getter);
            if (methodList!=null) {
                //循环执行每个订阅方法
                for (MethodManager method : methodList) {
                    //isAssignableFrom （两者参数是否一致，发布者和订阅者）
                    if(method.getType().isAssignableFrom(setter.getClass())){
                        invoke(method,getter,setter);
                    }
                }
            }
        }
    }

    private void invoke(MethodManager method, Object getter, Object setter) {
        Method execute = method.getMethod();
        try {
            execute.invoke(getter,setter);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
