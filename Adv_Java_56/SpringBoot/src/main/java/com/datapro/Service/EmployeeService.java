package com.datapro.Service;

import com.datapro.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee deleEmployee(Long emp_id);
    Employee displayEmployee(Long emp_id);
    List<Employee> allEmployee();
}
