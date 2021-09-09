package com.gyw.controller;

import com.gyw.pojo.User;
import com.gyw.service.UserService;
import com.gyw.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {

        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        session.setAttribute("code",securityCode);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image,"png",outputStream);
    }

    @PostMapping("/register")
    public String register(User user, HttpSession session,String code){

        String code2 = (String) session.getAttribute("code");
        if(code2.equalsIgnoreCase(code)){
            userService.save(user);
            return "redirect:/index";
        }
        return "redirect:/ToRegist";
    }

    @PostMapping("/login")
    public String login(String username, String password,HttpSession session){
        User user = userService.login(username,password);
        session.setAttribute("user",user);
        if(user != null){
            return "redirect:/emp/findAll";
        }
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}