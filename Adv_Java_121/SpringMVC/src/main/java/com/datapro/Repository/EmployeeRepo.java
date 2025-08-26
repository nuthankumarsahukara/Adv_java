package com.datapro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.datapro.Model.*;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {


}
