package com.datapro.Controllers;

import com.datapro.Model.Employee;
import com.datapro.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.Base64;
import java.util.List;

@RestController
public class EmployeeControllers {

    @Autowired
    private EmployeeService service;

    @PostMapping(value="/addEmployee",consumes =MediaType.MULTIPART_FORM_DATA_VALUE)
    public Employee addEmployee(@RequestParam("emp_name") String empName,
                                @RequestParam("emp_dob") Date empDOB,
                                @RequestParam("emp_dept") String empDept,
                                @RequestParam("emp_gender") String empGender,
                                @RequestParam("emp_sal") Double empSal,
                                @RequestParam("emp_email") String empEmail,
                                @RequestParam("emp_phone") Long empPhone,
                                @RequestParam(value="emp_photo",required = false)MultipartFile file
                                )throws IOException {
        Employee employee =new Employee();
        employee.setEmp_name(empName);
        employee.setEmp_dob(empDOB);
        employee.setEmp_dept(empDept);
        employee.setEmp_gender(empGender);
        employee.setEmp_sal(empSal);
        employee.setEmp_email(empEmail);
        employee.setEmp_phone(empPhone);

        if(file !=null && !file.isEmpty()){
            employee.setEmp_photo(file.getBytes());
        }else{
            employee.setEmp_photo(null);
        }
        return service.addEmployee(employee);
    }

    @PutMapping(value="/updateEmployee/{emp_id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Employee updateEmployee(@PathVariable("emp_id") Long emp_id,
                                   @RequestParam("emp_name") String empName,
                                   @RequestParam("emp_dob") Date empDOB,
                                   @RequestParam("emp_dept") String empDept,
                                   @RequestParam("emp_gender") String empGender,
                                   @RequestParam("emp_sal") Double empSal,
                                   @RequestParam("emp_email") String empEmail,
                                   @RequestParam("emp_phone") Long empPhone,
                                   @RequestParam(value="emp_photo",required = false)MultipartFile file
                                    )throws IOException{
        Employee e=service.displayEmployee(emp_id);
        e.setEmp_name(empName);
        e.setEmp_dob(empDOB);
        e.setEmp_dept(empDept);
        e.setEmp_gender(empGender);
        e.setEmp_sal(empSal);
        e.setEmp_email(empEmail);
        e.setEmp_phone(empPhone);
        if(file !=null && !file.isEmpty()){
            e.setEmp_photo(file.getBytes());
        }
        return service.addEmployee(e);
    }

    @DeleteMapping("/deleteEmployee/{emp_id}")
    public String deleEmployee(@PathVariable("emp_id") Long emp_id){
        service.deleEmployee(emp_id);
        return "Employee Deleted Successfully";
    }

    @GetMapping("/displayEmployee/{emp_id}")
    public Employee displayEmployee(@PathVariable("emp_id") Long emp_id){
        return service.displayEmployee(emp_id);
    }

    @GetMapping({"/","AllEmployee"})
    public List<Employee> allEmployee(){
        return service.allEmployee();
    }

    @GetMapping("/image/{emp_id}")
    public String displayPhoto(@PathVariable("emp_id") Long emp_id){
        Employee e=service.displayEmployee(emp_id);
        byte[] photo=e.getEmp_photo();
        return Base64.getEncoder().encodeToString(photo);
    }
}
