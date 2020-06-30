# Springboot-Union
Spirngboot的整合ActiveMQ框架的测试

第一步：创建项目工程，在pom.xml中添加相应的依赖

    主要是：
        <!--ActiveMQ的启动器-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-activemq</artifactId>
            <version>2.3.0.RELEASE</version>
        </dependency>
        
第二步：在application.yml进行配置
        
        一般需要修改服务的端口 
            server:
                port: 7878
                
        配置ActiveMq的相关信息
            spring:
              activemq:
                broker-url: 192.168.25.134:61616
                user: admin
                password: admin
              jms:
                pub-sub-domain: false # false是代表使用队列Queue，true 代表使用主题 Topic

第三步：配置相应的Spring Bean 
       
