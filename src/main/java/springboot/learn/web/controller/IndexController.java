package springboot.learn.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {

    /**
     *  Thymeleaf 的默认配置：可以使用spring.thymeleaf 进行修改
     *      默认的字符： UTF-8
     *      默认模板文件前缀：classpath:/templates/
     *      后缀：.html
     *   在html中要使用thymeleaf模板引擎，需要 在html 标签中 加入 <html lang="en" xmlns="http://www.thymeleaf.org">
     *       可以使用的标签：
     *          thymeleaf：        jsp：
     *    片段包含：      th:insert          jsp:include
     *                  th:replace
     *     遍历：        th:each            c:forEach
     *     条件判断：    th:if               c:if
     *                  th:unless
     *                  th:witch
     *                  th:case
     *     变量生命：     th:object
     *                  th:with
     *     属性修改：     th:arr
     *                  th:attrprepend
     *                  th:attrapend
     *     修改指定的属性默认值：
     *                  th:value
     *                  th:href
     *                  th:src
     *                  ...
     *
     *     修改标签内容 ： th:text   （转义特殊字符）
     *                  th:utext （不转义特殊字符）
     *
     *
     *
     *
     *
     * */
    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello","hello world");
        modelAndView.setViewName("/index");
        return modelAndView;
    }
}
