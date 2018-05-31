package controller;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(String loginname, String password, ModelAndView modelAndView, HttpSession session) {

        User user = userService.login(loginname, password);
        if (user != null) {
            //登录成功,将user对象设置到HttpSession作用域
            session.setAttribute("user", user);
            //转发到main请求
            modelAndView.setView(new RedirectView("/main"));
        } else {
            //登陆失败,设置失败提示消息,并跳转到登陆页面
            modelAndView.addObject("message", "用户名或密码错误,请重新输入!");
            modelAndView.setViewName("loginForm");
        }

        return modelAndView;
    }
}
