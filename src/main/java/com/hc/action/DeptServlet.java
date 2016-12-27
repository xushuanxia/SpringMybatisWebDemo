package com.hc.action;

import com.hc.service.DeptService;
import com.hc.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/13.
 */
@javax.servlet.annotation.WebServlet(name = "DeptServlet",urlPatterns = {"/deptServlet"})
public class DeptServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptServiceImpl deptService = (DeptServiceImpl) act.getBean("deptServiceImpl");
        response.getWriter().println(deptService.findAllDepts());
    }
}
