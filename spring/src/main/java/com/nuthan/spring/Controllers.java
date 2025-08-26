package com.nuthan.spring;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controllers {

    @GetMapping("/")
    public String getIndex(HttpServletRequest request){
        return "welcome to Datapro "+request.getSession().getId();
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        std.add(student);
        return student;
    }

    private List<Student> std= new ArrayList<>(List.of(
            new Student(101,"Nuthan",98),
            new Student(102,"Raju",85),
            new Student (103,"Ganesh",90)
    ));

    @GetMapping("/students")
    public List<Student> getStudent(){
        return std;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
