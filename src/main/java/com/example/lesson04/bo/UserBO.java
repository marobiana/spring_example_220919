package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.UserDAO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	public void addUser(String name, String yyyymmdd, String email, String introduce) {
		userDAO.insertUser(name, yyyymmdd, email, introduce);
	}
}



