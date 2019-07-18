package com.fortinet.fortinac.demo.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fortinet.fortinac.demo.user.domain.User;
import com.fortinet.fortinac.demo.user.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {	
	@Autowired
	private UserService userService;

	@RequestMapping("/detail/{id}")
	public User detail(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}

	@RequestMapping("/list")
	public List<User> list() {
		return userService.listUsers();
	}
	
    @RequestMapping(value="/insert", method=RequestMethod.POST, produces="application/json")
	public User insert(@RequestBody User user) {
		userService.insertUser(user);
		
		return user;
	}
	
    @RequestMapping(value="/update", method=RequestMethod.POST, produces="application/json")
	public boolean update(@RequestBody User user) {
		userService.updateUser(user);
		
		return true;
	}
	
    @RequestMapping(value="/delete", method=RequestMethod.POST, produces="application/json")
	public boolean delete(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		
		return true;
	}
}
