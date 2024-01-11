package com.example.helloworld.controller;

import com.example.helloworld.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author vikingar
 * @time 2024/1/11 11:21
 * @description
 */
// 而不使用 @Controller ，因为不需要返回视图数据，否则前后端不分离，@RestController 默认将返回的对象转化为 json 格式
@RestController
@RequestMapping
public class HelloController {

    /**
     * 没有在yml指定端口默认使用tomcat默认的8080
     * @return string
     */
    @GetMapping("/get1")
    public String get1(String name, String pwd) {
        return "hello " + name + ", your password is " + pwd;
    }

    /**
     * 如果传入的参数是 nickname 不是 name， 需要加注解
     * @param name name
     * @return string
     */
    @GetMapping("get2")
    public String get2(@RequestParam("nickname") String name) {
        return "your name is " + name;
    }

    /**
     * post requests.
     * @param name name
     * @param pwd pwd
     * @return str
     */
    @PostMapping("post1")
    public String post1(String name, String pwd) {
        return "your name is " + name + " your password is " + pwd;
    }

    /**
     * 此时前端传入的数据是 x-www-form-urlencoded 类型，可以直接使用对象接受参数
     * @param user o
     * @return str
     */
    @PostMapping("post2")
    public String post2(User user) {
        System.out.println(user.getUsername());
        System.out.println(user);
        return String.valueOf(user);
    }

    /**
     * 如果前端传入的是 json 数据类型，那么要使用 @RequestBody 注解接受
     * 并且 User 对象中的属性名要和请求体中的参数保持一致
     * @param user user
     * @return str
     */
    @PostMapping("post3")
    public String post3(@RequestBody User user) {
        System.out.println(user);
        return String.valueOf(user);
    }

    /**
     * 通配符路由，可以路由到/test/下的任何路径
     * @return str
     */
    @GetMapping("test/**")
    public String getAll() {
        System.out.println("通配符");
        return "通配符";
    }

    /**
     * 通配符路由，只能路由到/test/下面的一级路径
     * @return str
     */
    @GetMapping("test2/*")
    public String getAll2() {
        System.out.println("通配符");
        return "通配符";
    }





}
