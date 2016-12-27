package com.hc.domain;

/**
 * Created by Administrator on 2016/12/15.
 */

/**
 * 表示Dept查询条件，它包含Dept表的所有字段
 */
public class DeptQuery {
    private Dept dept;
    private Dept2 dept2;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept2 getDept2() {
        return dept2;
    }

    public void setDept2(Dept2 dept2) {
        this.dept2 = dept2;
    }
}
