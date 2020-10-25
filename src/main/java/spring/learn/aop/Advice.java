package spring.learn.aop;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Advice {

    @Pointcut("execution(* spring.learn.aop.AopTarget.*(..))")
    public void methodExpress(){
    }

    @Before("methodExpress()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("我是前置通知!!!");
        Signature signature = joinPoint.getSignature();
        // AOP代理类的名字
        System.out.println(signature.getDeclaringTypeName());
        // AOP代理类的类（class）信息
        signature.getDeclaringType();
        System.out.println( "代理的目标对象"+joinPoint.getTarget());
        // 调用的方法是：

        System.out.println("调用的方法是："+signature.getName());

        // 获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        for(int i = 0; i <obj.length;i++){
            System.out.println("传递的参数"+i+":"+obj[i]);
        }
    }

    // 后置通知:无论是否发生异常，都会调用的，但是无法访问方法的返回的结果
    @After("methodExpress()")
    public void after(JoinPoint joinPoint){
        System.out.println("我后置通知!!!");
        Signature signature = joinPoint.getSignature();
        // AOP代理类的名字
        System.out.println(signature.getDeclaringTypeName());
        // AOP代理类的类（class）信息
        signature.getDeclaringType();
        System.out.println( "代理的目标对象"+joinPoint.getTarget());
        // 调用的方法是：

        System.out.println("调用的方法是："+signature.getName());

        // 获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        for(int i = 0; i <obj.length;i++){
            System.out.println("传递的参数"+i+":"+obj[i]);
        }
    }

    @AfterReturning(value = "methodExpress()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println("我后置返回通知通知!!!");
        Signature signature = joinPoint.getSignature();
        // AOP代理类的名字
        System.out.println(signature.getDeclaringTypeName());
        // AOP代理类的类（class）信息
        signature.getDeclaringType();
        System.out.println( "代理的目标对象"+joinPoint.getTarget());
        // 调用的方法是：

        System.out.println("调用的方法是："+signature.getName());

        // 获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        for(int i = 0; i <obj.length;i++){
            System.out.println("传递的参数"+i+":"+obj[i]);
        }
        System.out.println("执行的结果是："+result);
    }

    @AfterThrowing(value = "methodExpress()",throwing = "e")
    public void afterReturning(JoinPoint joinPoint,Exception e){
        System.out.println("我后置返回通知通知!!!");
        Signature signature = joinPoint.getSignature();
        // AOP代理类的名字
        System.out.println(signature.getDeclaringTypeName());
        // AOP代理类的类（class）信息
        signature.getDeclaringType();
        System.out.println( "代理的目标对象"+joinPoint.getTarget());
        // 调用的方法是：

        System.out.println("调用的方法是："+signature.getName());

        // 获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        for(int i = 0; i <obj.length;i++){
            System.out.println("传递的参数"+i+":"+obj[i]);
        }
        // 对异常进行输出
        System.out.println(e.getLocalizedMessage());
    }

    // 单独用于测试环绕通知Around
    @Around("execution(* spring.learn.aop.AopTargetAround.addAround(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("调用的方法"+methodName);
        try {
            System.out.println("调用前置后置");
            result = proceedingJoinPoint.proceed();
            System.out.println("调用后置返回通知");
        }catch (Exception e){
            System.out.println("调用异常通知");
            e.printStackTrace();
        }finally {
            // 无论是否发生异常都会调用
            System.out.println("调用后置通知");
            return  result;
        }

    }
}
