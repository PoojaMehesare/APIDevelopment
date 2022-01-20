package com.main.service;

import com.main.model.LoginDTO;

public interface LoginService {

	String login(LoginDTO loginDTO);
	
	boolean forgot(String email, LoginDTO loginDTO);
}
