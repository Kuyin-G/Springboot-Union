package spring.learn.service;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import spring.learn.entity.Functions;


@Setter
@Getter
public class UseService {
    private Functions functions;
    public void useFunctions(String word){
        System.out.println(functions.sayHello(word));
    }

    public Functions getFunctions() {
        return functions;
    }

    public void setFunctions(Functions functions) {
        this.functions = functions;
    }
}
