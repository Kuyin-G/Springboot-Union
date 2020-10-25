package spring.learn.aop;


import org.springframework.stereotype.Component;

@Component
public class AopTarget {

    public int add(int a,int b){
        return a+b;
    }

    public int sub(int a,int b){
        System.out.println("参数a："+a);
        System.out.println("参数b"+b);
        return a-b;
    }

    public int div(int a,int b){
        return a/b;
    }

    public int addAround(int a,int b){
        System.out.println("测试Around环绕通知的方法");
        return  a+b;
    }
}
