package com.deloitte.userRegistration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.userRegistration.entity.User;

@RestController
public class UserController {

	@RequestMapping("/users")
	public List<User> getAllUsers() {

		System.out.println("inside get all users...");
		List<User> users = new ArrayList<User>();
		users.add(new User("1", "aa", "aaa", "india"));
		users.add(new User("2", "bb", "bbb", "india"));
		users.add(new User("3", "cc", "ccc", "india"));
		return users;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@RequestBody User user) {

		System.out.println("inside create user...");

		return "created";
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/users")
	public String updateUserById(@RequestBody User user) {


		return "updated";
	}


}
