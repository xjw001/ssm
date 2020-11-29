package com.xjw.test;


import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.SimpleExecutor;

import java.util.concurrent.ConcurrentHashMap;

public class MybatisTest {

    public void doUpdate(){
       // SimpleExecutor simpleExecutor = new SimpleExecutor();
        ConcurrentHashMap c = new ConcurrentHashMap();
        c.put("3","4");
    }
}
