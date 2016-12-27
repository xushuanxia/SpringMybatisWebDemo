package com.hc.service.impl;

import com.hc.dao.Dept2Dao;
import com.hc.dao.DeptDao;
import com.hc.domain.Dept;
import com.hc.domain.Dept2;
import com.hc.domain.DeptQuery;
import com.hc.service.DeptService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {//deptServiceImpl

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private Dept2Dao dept2Dao;

    public List<Dept> findAllDepts() {
        return deptDao.selectAll();
    }

    public List<Dept2> findDeptsByCondition(DeptQuery deptQuery) {
        return  dept2Dao.selectDept2s(deptQuery);
    }

    public Dept findeDeptById(int deptno) {
        return deptDao.selectByPrimaryKey(deptno);
    }

    public boolean updateDept(int id, Dept dept) {
        dept.setDeptno(id);
        return deptDao.updateByPrimaryKeySelective(dept)==1?true:false;
    }
}
