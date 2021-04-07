package com.store.basma.service;

import com.store.basma.enity.User;
import com.store.basma.enity.UserLoginRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserLoginRequest login);
}

/*public interface UserService extends UserDetailsService {

    public List<User> findAll();

    public User findById(long theId);

    public void save(User theUser);

    public void deleteById(long theId);
}*/
