package com.nuthan.SpringSecurity.Controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String getIndex(HttpServletRequest request){
        return "Welcome to Spring Security "+request.getSession().getId();
    }

}
