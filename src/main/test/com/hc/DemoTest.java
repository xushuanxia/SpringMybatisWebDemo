package com.hc;

import com.hc.dao.Dept2Dao;
import com.hc.dao.DeptDao;
import com.hc.dao.EmpDao;
import com.hc.domain.Dept;
import com.hc.domain.Dept2;
import com.hc.domain.DeptQuery;
import com.hc.service.DeptService;
import com.hc.service.impl.DeptServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileReader;
import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */
public class DemoTest {
    @Test
    public void fun1() throws Exception {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSessionFactory factory = (SqlSessionFactory) act.getBean("sqlSessionFactory");
        SqlSession session = factory.openSession();

        Dept2Dao dept2Dao = session.getMapper(Dept2Dao.class);

        DeptQuery deptQuery = new DeptQuery();

        Dept2 dept22 = new Dept2();

        dept22.setYusuan(310);

        deptQuery.setDept2(dept22);

        List<Dept2> dept2s = dept2Dao.selectDept2s(deptQuery);
        for(Dept2 dept2 : dept2s){
            System.out.println(dept2+"  "+dept2.getKouhao()+dept2.getYusuan());
        }

    }

}
