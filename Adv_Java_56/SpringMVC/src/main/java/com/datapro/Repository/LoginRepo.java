package com.datapro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datapro.Model.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long> {

	Login findByEmailAndPassword(String email, String password);
	
}
