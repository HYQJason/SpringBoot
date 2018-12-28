package com.example.demo.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBUtils {
    private SqlSessionFactory sqlSessionFactory;

    private DBUtils(){
        //通过配置文件获取数据库连接配置信息
        try {
            Reader readr = Resources.getResourceAsReader("conf.xml");
            //通过配置信息构建一个SqlSessionFactory
            this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(readr);
        }catch (IOException e){
            e.printStackTrace();
            this.sqlSessionFactory=null;
        }
    }

    private static class DBHoder{
        private final static DBUtils Instance = new DBUtils();
    }

    public static DBUtils getInstance(){
        return DBHoder.Instance;
    }

    public SqlSession getSqlSession(){
        if(sqlSessionFactory==null)
            throw new NullPointerException("SqlSessionFactory构造异常");
        //通过SqlSessionFactory打开一个数据库会话
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        return sqlSession;
    }
}
