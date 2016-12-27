package com.hc.action;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/12/21.
 */
public class DDController {

    @RequestMapping("/sth/login")
    public String login(HttpSession session, String username){
        if (username!=null) {
            session.setAttribute("username", username);
            return "redirect:/dept/re.action";
        }else
            return "redirect:/dept/re.action";
    }
}
