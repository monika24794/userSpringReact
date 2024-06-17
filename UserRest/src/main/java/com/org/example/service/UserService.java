package com.org.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.example.custumExption.UserNotFoundException;
import com.org.example.dao.UserRepo;
import com.org.example.entity.User;

@Service
public class UserService implements CurdService<User, Integer> {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User create(User user) {

		return userRepo.save(user);
	}

	@Override
	public List<User> fetchAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User fetchById(Integer id) {

		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Invalid id"));
	}

	@Override
	public User update(User updateadUser, User existingUser) {
		existingUser.setUserName(updateadUser.getUserName());
		existingUser.setPassword(updateadUser.getPassword());
		return userRepo.save(existingUser);
	}

	@Override
	public String delete(User user) {
		userRepo.delete(user);
		return user.getId() + "deletead .";
	}
 public User feachUserByUserName(String userName)
 {
	 return userRepo.findByuserName(userName );
 }
	
}
