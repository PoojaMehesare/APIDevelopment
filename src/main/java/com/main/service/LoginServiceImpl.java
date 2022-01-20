package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.LoginDTO;
import com.main.model.Employee;
import com.main.repository.EmployeeRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	EmployeeRepository tRepo;
	
	
	@Override
	public String login(LoginDTO loginDTO) {
		
//		boolean checkEmail = loginDTO.getEmail().isEmpty();
//		if(checkEmail) {
//			return "false";
//		}
		
		Employee teacher = tRepo.getByEmail(loginDTO.getEmail());
		if(teacher == null) {
			return "false";
		}
		
		if(teacher.getPassword().equals(loginDTO.getPassword())) {
			return "true";
		}
			return "false";
	}


	@Override
	public boolean forgot(String email, LoginDTO loginDTO) {
		
		Employee teacher = tRepo.getByEmail(email);
		if(teacher == null) {
			return false;
		}
		else {
			teacher.setPassword(loginDTO.getPassword());
			tRepo.save(teacher);
			return true;
		}
		
	}

}
