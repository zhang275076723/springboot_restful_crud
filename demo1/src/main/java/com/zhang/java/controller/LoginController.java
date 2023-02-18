package com.zhang.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Author zsy
 * @Create 2020/4/14 11:00
 * @Description
 */
@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        ModelMap modelMap, HttpSession session) {
        if ("admin".equals(username) && "123456".equals(password)) {
            session.setAttribute("username", username);
            return "redirect:/main.html";
        }
        modelMap.addAttribute("msg", "密码错误");
        return "index";
    }

}
