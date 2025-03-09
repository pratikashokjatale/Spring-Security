package com.app.crud.DaoImpl;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.crud.model.Employewithrole;



@Repository
public interface StudentDaoImpl  extends JpaRepository<Employewithrole, Integer>{
	
	

}
