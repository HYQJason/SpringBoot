package com.example.demo.controller;

import com.example.demo.bean.UsreInfo;
import com.example.demo.db.DBUtils;
import com.example.demo.db.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//@Controller：用于定义控制器类，在spring 项目中由控制器负责将用户发来的URL请求转发到对应的服务接口（service层），一般这个注解在类中，通常方法需要配合注解@RequestMapping。

//@RestController：用于标注控制层组件(如struts中的action)，@ResponseBody和@Controller的合集。
@RequestMapping("/test")
@RestController
@EnableAutoConfiguration
public class LoginController {

    /**
     * @ResponseBody：表示该方法的返回结果直接写入HTTP response body中，一般在异步获取数据时使用，用于构建RESTful的api。
     * 在使用@RequestMapping后，返回值通常解析为跳转路径，加上@responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。
     * 比如异步获取json数据，加上@responsebody后，会直接返回json数据。该注解一般会配合@RequestMapping一起使用。
     * @RequestMapping：提供路由信息，负责URL到Controller中的具体函数的映射。
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam(value = "phone")String phone,@RequestParam(value = "password")String password, @RequestParam(value = "token",required = false)String token) {
        //账号密码登录
        //根据token 快捷login登录

        //查询数据库，返回用户信息
        return "ss";
    }

    @RequestMapping("/register")
    public String Register(@RequestParam(value = "account")Long account,@RequestParam(value = "name")String name,@RequestParam(value = "age")Integer age,@RequestParam(value = "id")Integer id) {
    UsreInfo usreInfo=new UsreInfo(name,age,id,account);
        System.out.print("-------------------------------------------------------"+usreInfo);
        SqlSession sqlSession = DBUtils.getInstance().getSqlSession();
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        try {
            int rows = userMapper.insertUser(usreInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.commit();
        sqlSession.close();
        return "ss";
    }

    @RequestMapping("/info")
    public UsreInfo getinfo(@RequestParam(value = "id") String id) {
        SqlSession sqlSession = DBUtils.getInstance().getSqlSession();
        UsreInfo usreInfo = new UsreInfo("张三", 20);
        return usreInfo;

    }
}
