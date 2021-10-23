package com.myapp.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.user.service.UserService;
import com.myapp.user.vo.Post;
import com.myapp.user.vo.User;

@RestController
@RequestMapping("/v1")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}	
	
	@GetMapping("/users")	
	public List<User> getUsers(){
		
		List<User> userList = userService.getUsers();		
		return userList;		
	}
	
	@GetMapping("/user")	
	public User getUser(@RequestParam int id){
		
		List<User>  userList = userService.getUsers();	
		List<Post>  postList = userService.getPosts();
		
		User user = null;
		for(User u: userList) {
			
			if(u.getId()==id) {
				user = u;
				break;
			}			
		}
		return user;
	}
	
	@GetMapping("/user1")	
	public User getUser1(@RequestParam int user_id){
		
		List<User>  userList = userService.getUsers();	
		List<Post>  postList = userService.getPosts();
		
		User user = null;
		for(User u: userList) {
			for(Post p: postList) {				
				if(u.getId()==p.getUser_id()) {
					user = u;
					break;
				}
				
			}
			
			}	
		return user;
	}
		
		
	
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User requestUserDetails) {
		
		User returnValue = new User();
		
        returnValue.setId(7891);
        returnValue.setName("Kargopolov");
        returnValue.setEmail("gurava.reddy246@gmail.com");
        returnValue.setGender("MALE");
        returnValue.setStatus("ACTIVE");
        
        return returnValue;
		
	}
	
	@GetMapping("/posts")
    public List<Post> getPosts(){
		
		List<Post> postList = userService.getPosts();		
		return postList;		
	}
	
	@GetMapping("/post")	
	public Post getPost(@RequestParam int id){
		
		List<Post>  postList = userService.getPosts();	
		
		Post post = null;
		for(Post p: postList) {
			
			if(p.getId()==id) {
				post = p;
				break;
			}			
		}
		return post;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	

	
	
	

}
