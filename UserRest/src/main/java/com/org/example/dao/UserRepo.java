package com.org.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.example.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> 
{
	
 User findByuserName(String userName);
 /* or we can handle this way also
 @Query(value = "SELECT * FROM USERS WHERE userName = ?1", nativeQuery = true)
 User findByuserName(String userName);*/

}
