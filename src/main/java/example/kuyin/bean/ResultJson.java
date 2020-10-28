package example.kuyin.bean;

import lombok.Data;


import java.util.HashMap;
import java.util.Map;

@Data
public class ResultJson<T>{
    // 定义两个常量
    private static final  String SUCCESS = "success";
    private static  final String FAILURE ="failure";

    //定义数据的容器
    private Map<String,T> data;
    private String result;


    // 将构造方法私有化
    private ResultJson(){
        super();
    }

    // 成功，无数据返回的时候
    public static ResultJson success(){
        ResultJson resultJson =new ResultJson();
        resultJson.setResult(SUCCESS);
        return resultJson;
    }

    // 成功，有数据返回的时候
    public static <T> ResultJson success(T t){

        HashMap<String,T> map = new HashMap<>();
        String key = t.getClass().getSimpleName();
        map.put(key,t);

        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.setData(map);
        resultJson.setResult(SUCCESS);
        return resultJson;
    }

    // 失败
    public static <T> ResultJson<T> failure(){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.setResult(FAILURE);
        return resultJson;
    }

    public static <T> ResultJson<T> failure(T t){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.setResult(FAILURE);
        return resultJson;
    }
}
