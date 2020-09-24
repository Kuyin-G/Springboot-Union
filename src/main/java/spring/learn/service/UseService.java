package spring.learn.service;

import spring.learn.entity.Functions;


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
