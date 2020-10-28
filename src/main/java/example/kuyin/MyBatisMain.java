package example.kuyin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("example.kuyin.mapper")
@SpringBootApplication
public class MyBatisMain {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisMain.class,args);
    }
}
