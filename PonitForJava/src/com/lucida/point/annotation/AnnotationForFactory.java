package com.lucida.point.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 注解与工厂的结合使用
 */
public class AnnotationForFactory {
    public static void main(String[] args) {
        MessageService messageService = new MessageService();
        messageService.send("hello");

    }
}
@Retention(RetentionPolicy.RUNTIME)
@interface MessageAnnotation{
    public Class<?> clazz();
}

@MessageAnnotation(clazz = NetMessageIml.class)
class MessageService{
    IMessage mIMessage;
    public MessageService(){
        MessageAnnotation annotation = MessageService.class.getAnnotation(MessageAnnotation.class);
        mIMessage = (IMessage) Factory.getInstance(annotation.clazz());
    }
    public void send(String msg){
        mIMessage.send(msg);
    }
}

/**
 * 工厂
 */
class Factory{
    private Factory(){}
    public static <T> T getInstance(Class<T> clazz){
        try {
            return (T) new MessageProxy().bind(clazz.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

interface IMessage{
    public void send(String msg);
}

class UseMessageIml implements IMessage{

    @Override
    public void send(String msg) {
        System.out.println("【用户消息发送】"+msg);
    }
}

class MessageProxy implements InvocationHandler{
    private Object target;
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    private boolean connect(){
        System.out.println("连接成功");
        return true;
    }

    private void close(){
        System.out.println("连接断开");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (this.connect()){
                return method.invoke(this.target,args);
            }else {
                throw new Exception("【ERROR】消息无法发送");
            }
        }finally {
            this.close();
        }

    }

}
class NetMessageIml implements IMessage{

    @Override
    public void send(String msg) {
        System.out.println("【网络信息发送】"+msg);
    }
}
