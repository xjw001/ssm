package com.xjw.test;

import com.xjw.bean.Dept;
import com.xjw.bean.User;
import com.xjw.dao.DeptMapper;
import com.xjw.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})
public class SpringTest {

    @Autowired
    private DeptMapper deptMapper;

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void testAddDept(){
        Integer a = 100,b = 100;
        Integer c = 1000,d = 1000;
        System.out.println(a==b);
        System.out.println(c==d);
//        deptMapper.insert(new Dept(7,"人力资源部"));
//        System.out.println("插入成功!");
    }

    @Test
    public void testAddUser() throws InterruptedException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //int initNum = 10000;
        for(int num = 0; num<10;num++) {
            long starttime = System.currentTimeMillis();
            int initNum = userMapper.getMaxUserId() + 1;
            for (int i = initNum; i < initNum + 30000; i++) {
                String username = UUID.randomUUID().toString().substring(0, 5) + i;
                String addr = null;
                if (i % 3 == 1) {
                    addr = i + "温州市瓯海区茶山街道";
                } else if (i % 3 == 2) {
                    addr = i + "温州市鹿城区五马街道";
                } else {
                    addr = i + "温州市瑞安塘下街道";
                }
               // Timestamp time1 = new Timestamp(System.currentTimeMillis());
                userMapper.insert(new User(i, username, addr, new Date()));
            }
            long endTime = System.currentTimeMillis();
            System.out.println("num:"+num+","+Thread.currentThread().getName()+"耗时(ms):" + (endTime - starttime));
        }
    }
}
