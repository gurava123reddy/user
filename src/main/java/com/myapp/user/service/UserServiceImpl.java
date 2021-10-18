package com.myapp.user.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myapp.user.vo.User;
import com.myapp.user.vo.UserList;

@Service
public class UserServiceImpl implements UserService {
	
    @Override
	public List<User> getUsers(){
		
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "https://gorest.co.in/public/v1/users";
		ResponseEntity<UserList> response
		  = restTemplate.getForEntity(fooResourceUrl, UserList.class);
		return response.getBody().getData();
		
	}

}
