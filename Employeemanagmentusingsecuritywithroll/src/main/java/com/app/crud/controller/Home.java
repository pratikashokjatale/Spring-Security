package com.app.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.Dao.StudentDao;
import com.app.crud.model.Employewithrole;

@RestController
public class Home {

	@Autowired
	private StudentDao dao;
	
	@PostMapping("/employewithroles")
	public String addStudent(@RequestBody Employewithrole stu) {
		dao.save(stu);
		return "student save successfully";
	}
	
	@GetMapping("/employewithroles")
	public List<Employewithrole> getdata(){
		
		return dao.getall();
	}
	
	@GetMapping("/employewithroles/{id}")
	public Optional<Employewithrole> getdata(@PathVariable int id){
		
		return dao.getbyid(id);
	}
	
	@DeleteMapping("/employewithroles/{id}")
		public String delete(@PathVariable int id) {
		dao.deletestudent(id);
		return "delete student";
	}
	
	@PutMapping("/employewithroles/{id}")
	public String update(@PathVariable int id,@RequestBody Employewithrole s) {
	dao.updatestudent(id,s);
	return "updtate student";
}

}
