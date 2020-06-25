package example.kuyin;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "example.kuyin.mapper")
@SpringBootApplication
public class MybatisPlusMain {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusMain.class,args);
    }
}
