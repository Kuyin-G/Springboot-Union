package spring.test.demo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.learn.aop.AopTarget;
import spring.learn.aop.AopTargetAround;
import spring.learn.async.AsyncTaskService;
import spring.learn.config.*;
import spring.learn.entity.Author;
import spring.learn.entity.Functions;
import spring.learn.listener.DemoPublisher;
import spring.learn.service.BeanWayService;
import spring.learn.service.JSR250WayService;
import spring.learn.service.UseService;

import java.io.IOException;

public class SpringTestDmo {
    /**
     * spring的Aop
     * 在配置文件中需要使用 @EnableAspectJAutoProxy 开启对Aop的支持
     * 在通知类中需要使用@Aspect 来标志是一个切面类，通知需要将该切面注册到Spring中（使用@Component）
     *      在切面类中：可以使用一个空的方法提来标志一个切点：
     *           @Pointcut("execution(* spring.learn.aop.AopTarget.*(..))")
     *              1. *  代表的是任意的返回值
     *              2. spring.learn.aop.AopTarget.* 代表的是该类中的任意的犯法
     *              3. .. :代表的是任意参数的方法
     *      切面方法类型：
     *          1.前置通知：@Before
     *              可使用 JoinPoint类型 作为参数，访问链接相关细节，如果方法名和方法参数等
     *          2.后置通知：@After （再方法执行后，无论是否发生异常，都会执行）
     *              可使用 JoinPoint类型 作为参数，访问链接相关细节，如果方法名和方法参数等，但是无法访问目标方法的的返回值（执行结果）
     *          3.返回通知：@AfterReturning
     *              可使用 JoinPoint类型 作为参数，访问链接相关细节，同时可以使用Object result 来访问方法的返回值（执行结果）
     *          4.异常通知：@AfterThrowing
     *              可以访问目标方法的异常结果，对结果进行处理，可以使用 指定的异常作为参数，例如：NullPointerException ne 等
     *          5.环绕通知：@Around
     *              需要使用ProcessingJoinPoint 类型作为参数
     * */
    @Test
    public void testSpringAop(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        AopTarget aopTarget = context.getBean(AopTarget.class);
        AopTargetAround targetAround = context.getBean(AopTargetAround.class);
        // 测试前置、后置返回通知、异常通知、后置通知
        aopTarget.add(1,2);
        // 这里会抛出一个异常
//        aopTarget.div(1,0);
        // 测试环绕通知
        targetAround.addAround(2,4);
        context.close();
    }
    /**
     * spring 的计划任务：
     * */

    @Test
    public void testSchedule() throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduleConfig.class);
        System.in.read();
    }


    /**
     * Spring的多线程
     *  1.config文件需要继承AsyncConfig接口，重写接口的方法getAsyncExecutor()
     *          这里返回一个ThreadPoolTaskExecutor
     *  2.在config文件中是注解 @EnableAsync 注解
     *  3.在需要进行异步调用的方法中使用 @Async 注解
     *  3.调用 @Async 注解的方法就是进行异步调用
     *
     * */
    @Test
    public void testAsyncThread(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        for (int i = 0 ;i<5 ;i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }

    /**
     * Spring的事件（Application Event）
     *  为bean与bean之间的消息通信提供了支持，当一个bean
     *  处理完一个任务之后，希望里一个bean知道并能做出相应的反应
     *  让一个bean监听当前bean所发送的事件
     * Spring的事件需要遵循如下流程：
     *  1.自定义事件，集成ApplicatonEvent（DemoEvent）
     *  2.自定义事件监听器实现ApplicationListener（DemoListener）
     *  3.使用容器发布事件 (application.publishEvent)
     * */
    @Test
    public void testApplicationEvent(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("我正在测试Application Event");
        context.close();
    }

    /**
     * 测试使用@Bean 的initMethod 和 destroyMethod
     *
     * 执行的时候是：
     *      1.先构造函数
     *      2.init方法
     *      3.终止程序的时候执行destroy方法
     * */
    @Test
    public  void testBeanInitDestroy(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InitAndDestroyConfig.class);
        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        System.out.println(beanWayService);

        JSR250WayService jSR250WayService = context.getBean(JSR250WayService.class);
        System.out.println(jSR250WayService);
        context.close();
    }


    /**
     * 测试使用@Scope注解将bean的创建设置为多例模式
     *
     * 执行结果：
     *             是否是同一个实例：false
     *             是否是同一个实例：true
     * */

    @Test
    public  void testScopePrototype(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        // 获取多个Function 进行比较
        Functions functions1 = context.getBean(Functions.class);
        Functions functions2 = context.getBean(Functions.class);
        System.out.println("是否是同一个实例："+(functions1 ==functions2));

        // 获取多个 userService
        UseService service1 = context.getBean(UseService.class);
        UseService service2 = context.getBean(UseService.class);
        System.out.println("是否是同一个实例："+(service1 ==service2));
    }

    /**
    * 测试从properties引用单个值，多个值
    * */
    @Test
    public void testImportValuesFromProperties(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Author author = context.getBean(Author.class);
        System.out.println(author);
    }

    /**
    * 测试使用@Bean 注解进行javabean的创建
     */
    @Test
    public void testUseBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseService useService = context.getBean(UseService.class);
        System.out.println("useService:"+useService);
        useService.useFunctions("word");
    }


}
