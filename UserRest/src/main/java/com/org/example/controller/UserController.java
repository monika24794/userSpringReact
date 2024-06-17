package com.org.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.example.custumExption.UserNotFoundException;
import com.org.example.dto.ErrorResponce;
import com.org.example.entity.User;
import com.org.example.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<?> registerdUser(@RequestBody User user) {
		User createdUser = userService.create(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllUserser() {
		try {
			return new ResponseEntity<>(userService.fetchAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>
			(new ErrorResponce("User Feacthing is failead", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable("userId") Integer id) {
		try {
			return  ResponseEntity.ok(userService.fetchById(id));
			
		} catch (Exception e) {
			
			ErrorResponce errorResponce=
		    new ErrorResponce("User Feacthing is failead", e.getMessage());
			return new ResponseEntity<>
			(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<?> updateuserById(@PathVariable("userId") Integer id,
			@RequestBody User updateUser) {
		try {
			User existingUser=userService.fetchById(id);
			
			return  ResponseEntity.ok(userService.update(updateUser, existingUser));
			
		} catch (Exception e) {
			
			ErrorResponce errorResponce= new ErrorResponce("User updation is failead", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?>deleteUserById(@PathVariable ("userId") Integer id)
	{ try {
		User existingUser=userService.fetchById(id);
		return ResponseEntity.ok(userService.delete(existingUser));
				
	} catch (Exception e) {

		ErrorResponce errorResponce= new ErrorResponce("User deletion is failead", e.getMessage());
		return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		
	}
		
	}
	@GetMapping("/getbyusername/{name}")
	public ResponseEntity<?>deleteUserById(@PathVariable ("name") String name)
	{
		try {
			ResponseEntity res= null;
			User foundUser = userService.feachUserByUserName(name);
			if(foundUser!=null) 
			{
				res.ok(foundUser);
			}
			else
			{
				throw new UserNotFoundException("invalid username");
			}
		return res;
		} catch (Exception e) {

			return new ResponseEntity<>(
			new ErrorResponce("User is not found ", e.getMessage()),
			HttpStatus.BAD_REQUEST);
			
		}
		
		
	}
	
}
