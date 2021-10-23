package com.myapp.user.service;

import java.util.List;

import com.myapp.user.vo.Post;
import com.myapp.user.vo.User;

public interface UserService {
	
	public List<User> getUsers();
	public List<Post> getPosts();
}
