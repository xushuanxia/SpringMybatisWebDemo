package com.hc.dao;

import com.hc.domain.Dept;
import com.hc.domain.Dept2;
import com.hc.domain.DeptQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Dept2Dao {
    Dept2 selectByPrimaryKey(Integer deptno);

    /**
     * 查找符合查询条件deptQuery的所有的Dept
     * @param deptQuery
     * @return
     */
    List<Dept2> selectDept2s(@Param("deptQuery") DeptQuery deptQuery);

}