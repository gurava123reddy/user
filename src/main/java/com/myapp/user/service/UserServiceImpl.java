package com.myapp.user.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myapp.user.vo.Post;
import com.myapp.user.vo.PostList;
import com.myapp.user.vo.User;
import com.myapp.user.vo.UserList;

//implementing UserService
@Service
public class UserServiceImpl implements UserService {
	
    
    @Override
    public List<Post> getPosts(){
    	
    	RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl1 = "https://gorest.co.in/public/v1/posts";
		ResponseEntity<PostList> response
		  = restTemplate.getForEntity(fooResourceUrl1, PostList.class);
		return response.getBody().getData();
    	
    }
    
    @Override
   	public List<User> getUsers(){
   		
   		RestTemplate restTemplate = new RestTemplate();
   		String fooResourceUrl = "https://gorest.co.in/public/v1/users";
   		String fooResourceUrl1 = "https://gorest.co.in/public/v1/posts";
   		ResponseEntity<UserList> response
   		  = restTemplate.getForEntity(fooResourceUrl, UserList.class );
   		List<User> users = response.getBody().getData();
   		
   		ResponseEntity<PostList> response1
 		  = restTemplate.getForEntity(fooResourceUrl1, PostList.class );
   		List<Post> posts = response1.getBody().getData();
   		
   		
   		for(Post post: posts) {
   			for(User user: users) {
   				if(post.getUser_id() == user.getId()) {   					
   					user.setPost(post);
   					break;
   					
   				}
   				
   			}
   		}	
   		
   		return users;
   		
   	}
    
    

}
