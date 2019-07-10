package cn.cxh.dao;

import cn.cxh.pojo.User;
import cn.cxh.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.dao
  User: myischenxiaohua@163.com
  Date: 2019/7/9
  Time: 11:15
*/public class UserDaoTest {
Logger log=Logger.getLogger(UserDaoTest.class);
    @Test
    public void count() {
        SqlSession sqlSession= MybatisUtil.createSqlSession();
        int it=sqlSession.getMapper(UserDao.class).count();
        log.debug(it);
    }

    @Test
    public void add() {
        SqlSession sqlSession= MybatisUtil.createSqlSession();
        User user=new User();
        user.setUserCode("zsf");
        user.setUserName("张三丰");
        user.setUserPassword("123");
        try {
            int it=sqlSession.getMapper(UserDao.class).add(user);
            sqlSession.commit(); //提交事务，只有查询语句不需要
            log.debug(it);
        } catch (Exception e) {
            e.printStackTrace();
            //事务回滚
            sqlSession.rollback();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void modify() {
        SqlSession sqlSession= MybatisUtil.createSqlSession();
        User user=new User();
        user.setId(21);
        user.setUserCode("zhangsan");
        user.setUserName("张三");
        user.setUserPassword("123456");

        try {
            sqlSession.getMapper(UserDao.class).modify(user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void updatePwd() {
        SqlSession sqlSession= MybatisUtil.createSqlSession();
        try {
            sqlSession.getMapper(UserDao.class).updatePwd(20,"123");
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void deleteUserById() {
        SqlSession sqlSession= MybatisUtil.createSqlSession();
        try {
            sqlSession.getMapper(UserDao.class).deleteUserById(17);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void getUserList() {
        SqlSession sqlSession=MybatisUtil.createSqlSession();
        List<User> list=new ArrayList();
        try {
            list=sqlSession.getMapper(UserDao.class).getUserList("李明",1,0,2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (User user:list) {
            log.debug("用户名："+user.getUserName()+"--角色名称："+user.getRole().getRoleName()+"--地址"+user.getAddresses().toString());
        }
    }
}