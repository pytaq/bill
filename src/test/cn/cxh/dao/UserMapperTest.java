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
  Time: 9:42
*/public class UserMapperTest {
    Logger log=Logger.getLogger(UserMapperTest.class);

    @Test
    public void selectUserByName() {
        SqlSession sqlSession=null;
        User user=null;
        try {
            sqlSession= MybatisUtil.createSqlSession();
            user= sqlSession.getMapper(UserDao.class).getLoginUser("liming");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }


            log.debug(user.getUserName());


    }
}