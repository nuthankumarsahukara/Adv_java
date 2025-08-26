package com.datapro.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.datapro.Model.Data;

public interface DataRepo extends JpaRepository<Data, Long>{

}
