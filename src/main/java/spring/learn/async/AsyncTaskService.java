package spring.learn.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

    // 使用Async注解表明该方法是个异步方法，如果注解类级别的，则表明该类所有的方法是异步方法
    // 这里的方法都会被注入使用ThraadPoolTaskExecutor 作为TaskExecutor
    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务1："+i);
    }

    public void executeAsyncTaskPlus(Integer i ){
        System.out.println("执行异步任务2："+(i+2));
    }

}
