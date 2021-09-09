package com.gyw.myconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("ems/login");
        registry.addViewController("/index").setViewName("ems/login");
        registry.addViewController("/ToRegist").setViewName("ems/regist");
        registry.addViewController("/ToSave").setViewName("ems/addEmp");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index","/","/ToRegist","/user/login","/css/*","/js/**","/img/**");
    }
}