package com.github.elizabetht.service;

import com.github.elizabetht.repository.UserRepository;

public class UserService {

	private UserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public String save(String userName, String password,
			String firstName, String lastName, String dateOfBirth,
			String emailAddress) {
		if (userRepository != null) {
			if (userRepository.findByUserName(userName)) {
				return "SignupFailure-UserNameExists";
			}
			userRepository.save(userName, password, firstName, lastName,
					dateOfBirth, emailAddress);
			return "SignupSuccess";
		} else {
			return "SignupFailure";
		}
	}

	public String findByLogin(String userName, String password) {
		String result = "LoginFailure";
		if (userRepository != null) {
			boolean status = userRepository.findByLogin(userName, password);
			if (status) {
				result = "LoginSuccess";
			}
		}
		return result;
	}
}
