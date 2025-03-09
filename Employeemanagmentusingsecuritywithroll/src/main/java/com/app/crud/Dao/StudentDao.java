package com.app.crud.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.crud.DaoImpl.StudentDaoImpl;
import com.app.crud.model.Employewithrole;



@Service
public class StudentDao {
	@Autowired
	private StudentDaoImpl si;
	
public void save(Employewithrole stu) {
	si.save(stu);
}

public List<Employewithrole> getall() {
	// TODO Auto-generated method stub
	return si.findAll();
}

public Optional<Employewithrole> getbyid(int id) {
	// TODO Auto-generated method stub
	return si.findById(id);
}

public void deletestudent(int id) {
	// TODO Auto-generated method stub
	si.deleteById(id);
	
}

public void updatestudent(int id, Employewithrole s) {
	// TODO Auto-generated method stub
	Optional<Employewithrole>stt=si.findById(id);
	if(stt.isPresent()){
		Employewithrole ss=stt.get();
		si.save(s);
	}
	
	
}


}
