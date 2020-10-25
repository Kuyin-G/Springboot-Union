package spring.learn.aop;



import org.springframework.stereotype.Component;


@Component
public class AopTargetAround {
    public int addAround(int a, int b){
        return  a+b;
    }
}
