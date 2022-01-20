package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.exception.CustomException;
import com.main.model.LoginDTO;
import com.main.service.LoginService;

@RestController
@RequestMapping(value = "/teachers/api")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) throws CustomException {

		String id = loginService.login(loginDTO);
		if (id.equals("true")) {
			return new ResponseEntity<String>("Login Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Login Failed", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PatchMapping("/forgot/{email}")
	public String forgot(@PathVariable("email") String email, @RequestBody LoginDTO loginDTO) throws CustomException {

		if (loginService.forgot(email, loginDTO)) {
			return "Password changed successfully";
		}

		return "Password changed failed";

	}

}
