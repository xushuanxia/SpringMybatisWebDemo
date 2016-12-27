package com.hc.action;

import com.hc.domain.Dept;
import com.hc.domain.Dept2;
import com.hc.domain.DeptQuery;
import com.hc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/14.
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

    @RequestMapping("/re")
    public void re(){
        System.out.println("re--------------");
    }

    @RequestMapping("/interceptor")
    public void interceptor(){
        System.out.println("interceptor******************");
    }

    @ModelAttribute("sth")
    public List<String> sthing(){
        List<String> sth=Arrays.asList(new String[]{"aa","aa","aa"});
        return sth;
    }

    @RequestMapping(value = "/huixian" ,method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView huixian(@ModelAttribute("dept") @Validated Dept dept,BindingResult bindingResult){

        System.out.println(dept);
        ModelAndView mav=new ModelAndView("/adddept.jsp");
        if (bindingResult.hasErrors()){
            ObjectError objectError = bindingResult.getAllErrors().get(0);

            String allerrors = objectError.getDefaultMessage();
            mav.addObject("allerrors",allerrors);
        }
        return mav;

    }

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/deptValidat",method = {RequestMethod.GET})
    public String deptValidat(Model model,@Validated Dept dept, BindingResult bindingResult){
        System.out.println("************");
        System.out.println(dept+"*(*(");
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for(ObjectError oe : allErrors)
            System.out.println(oe.getDefaultMessage());
        model.addAttribute("allErrors",allErrors);
        return "/error.jsp";
    }


    @RequestMapping("/dept10/{deptno}")
    public void dept10(@PathVariable("deptno")String dn,HttpServletResponse response){
        System.out.println(dn);
        String x=dn+3;
        System.out.println(x);
        Dept dept=new Dept(10,"aa","aaa");

        try {
            response.getWriter().write(dept.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/jsonReq",method = {RequestMethod.POST,RequestMethod.GET})
    public void jsonReq(String deptStr , HttpServletResponse response){
        System.out.println(deptStr);
        //采用FastJSON构造Dept进行处理
        Dept dept = new Dept(123, "123", "123");
        //采用FastJSON构造Dept进行处理
        try {
            response.getWriter().write(dept.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/batchAdd",method = {RequestMethod.POST})
    public void batchAdd(Dept dept){ //绑定数组
        System.out.println(dept.getDepts()+"*");
    }

    @RequestMapping(value = "/batchDelete",method = {RequestMethod.POST})
    public void batchDelete(Integer[] key){ //绑定数组
        System.out.println("fd "+ Arrays.asList(key)+" "+key.length);
    }

    @RequestMapping(value = "/findDepts",method = {RequestMethod.POST})
    public ModelAndView findDepts(DeptQuery deptQuery){
        System.out.println("findDepts "+deptQuery);
        List<Dept2> depts =deptService.findDeptsByCondition(deptQuery);
        System.out.println(depts);
        return new ModelAndView("/index.jsp","depts", depts);
    }

    @RequestMapping(value = "/showDepts", method = {RequestMethod.GET})
    public ModelAndView showDepts() throws Exception {
        List<Dept> depts = deptService.findAllDepts();
        return new ModelAndView("/index.jsp", "depts", depts);
    }

    @RequestMapping(value = "/showEditDeptPage", method = {RequestMethod.GET})
    public String showEditDeptPage(Model model, int deptno) throws Exception {
        Dept dept = deptService.findeDeptById(deptno);
        model.addAttribute("dept", dept);
        return "/deptEdit.jsp"; //此处的'/'表示项目根目录
    }

    @RequestMapping(value = "/editDept", method = {RequestMethod.GET, RequestMethod.POST})
    public String editDept(Model model, int deptno, Dept dept) throws Exception {
        //处理器适配器调用SpringMVC的参数绑定组件，会将客户端提交的key/value形式的数据转换成Controller方法的形参，形参的名称即为key
        boolean res = deptService.updateDept(deptno, dept);
//        res = false;
        if (res) { //重定向，method必须得支持RequestMethod.GET
            return "redirect:showDepts.action";

        } else { //转发
            model.addAttribute("dept", dept);
            return "forward:/deptRes.jsp";
        }
    }
    @RequestMapping(value = "/string2Date")
    public void string2Date(Date hireDate){
        System.out.println(hireDate);
    }

}
