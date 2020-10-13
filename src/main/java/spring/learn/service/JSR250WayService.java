package spring.learn.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {


    @PostConstruct
    public void init(){
        System.out.println("JSR250注解-@PostConstruct-init-method");
    }

    public JSR250WayService(){
        super();
        System.out.println("JSR250WayService构造函数");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("JSR250-@PreDestroy-destroy-method");
    }


}
