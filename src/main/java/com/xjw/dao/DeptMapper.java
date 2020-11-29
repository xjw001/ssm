package com.xjw.dao;

import com.xjw.bean.Dept;
import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptid);

    int insert(Dept record);

    Dept selectByPrimaryKey(Integer deptid);

    List<Dept> selectAll();

    int updateByPrimaryKey(Dept record);
}