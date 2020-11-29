package com.xjw.test;

import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml","classpath:spring/spring-mvc.xml"})
public class MVCTest {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage(){
        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/getAllUser")
                    .param("pageNum","2")).andReturn();
            MockHttpServletRequest mockHttpServletRequest = result.getRequest();
           PageInfo pageinfo = (PageInfo) mockHttpServletRequest.getAttribute("pageInfo");
            System.out.print(pageinfo);
           System.out.println("当前页码："+pageinfo.getPageNum());
            System.out.println("总页码："+pageinfo.getPages());
            System.out.println("总记录数："+pageinfo.getTotal());
            System.out.println("连续显示的页码：");
            int[] navigatepageNums = pageinfo.getNavigatepageNums();
            for (int i =0 ;i<navigatepageNums.length;i++){
                System.out.println(navigatepageNums[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
