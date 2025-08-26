package com.datapro.Service;

import com.datapro.Model.Employee;
import com.datapro.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements  EmployeeService {
    @Autowired
    private EmployeeRepo repo;
    @Override
    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee deleEmployee(Long emp_id) {
            repo.deleteById(emp_id);
        return null;
    }

    @Override
    public Employee displayEmployee(Long emp_id) {
        return repo.findById(emp_id).get();
    }

    @Override
    public List<Employee> allEmployee() {
        return repo.findAll();
    }
}
