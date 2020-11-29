package com.xjw.test;
import com.xjw.bean.Dept;
import com.xjw.dao.DeptMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MapperTest {

    @Test
    public  void testAddDept(){
        //创建spring容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        DeptMapper deptMapper = ioc.getBean(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDeptid(4);
        dept.setDeptname("总经办");
        deptMapper.insert(dept);
        System.out.println("插入成功！");
    }
}
