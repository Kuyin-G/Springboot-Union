package example.kuyin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {

    // StringRedisTemplate
    @Autowired
    private StringRedisTemplate template;

    @Test
    public void test01(){
        //Redis中String类型的操作器
        ValueOperations<String, String> operations = template.opsForValue();
        // 插入String类型的数据
        operations.set("Spring:redis:test","test");
        // 获取 Spring:redis:test 键的值
        String s = operations.get("Spring:redis:test");
        System.out.println(s);
    }

}
