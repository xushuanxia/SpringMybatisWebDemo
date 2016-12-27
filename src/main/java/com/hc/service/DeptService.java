package com.hc.service;

import com.hc.domain.Dept;
import com.hc.domain.Dept2;
import com.hc.domain.DeptQuery;

import java.util.List;

public interface DeptService {
    List<Dept> findAllDepts();
    List<Dept2> findDeptsByCondition(DeptQuery deptQuery);

    Dept findeDeptById(int deptno);

    boolean updateDept(int id, Dept dept);
}
