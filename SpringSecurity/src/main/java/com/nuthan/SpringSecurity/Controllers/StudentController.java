package com.nuthan.SpringSecurity.Controllers;

import com.nuthan.SpringSecurity.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    

    @GetMapping("/student")
    public Student allStudent(){
        return  null;
    }
}
