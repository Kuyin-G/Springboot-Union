package spring.learn.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
@ToString
// 自定义事件
public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String msg;
    public DemoEvent(Object source) {
        super(source);
    }
    public DemoEvent(Object source,String msg){
        super(source);
        this.msg =msg;
    }

}
