package com.store.basma.service;

import com.store.basma.enity.User;
import com.store.basma.enity.UserLoginRequest;
import com.store.basma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }



    public User save(UserLoginRequest login){
        User user = new User();
        user.setEmail(login.getEmail());
        user.setEncryptedPassword(login.getPassword());
        user.setEmail(login.getEmail());
        user.setEncryptedPassword(passwordEncoder.encode(login.getPassword()));
       // user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(user.getEmail(),user.getEncryptedPassword(),new ArrayList<>());
    }}
        /*return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getEncryptedPassword(),
                mapRolesToAuthorities(user.getRoles()));*/


    /*private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }*/


/*@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(@Qualifier("userRepositoryImpl") UserRepository theuserRepository) {
        userRepository = theuserRepository;
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User findById(long theId) {
        return userRepository.findById(theId);
    }

    @Override
    @Transactional
    public void save(User theUser) {
       theUser.setEncryptedPassword(bCryptPasswordEncoder.encode(theUser.getEncryptedPassword()));
        userRepository.save(theUser);
    }

    @Override
    @Transactional
    public void deleteById(long theId) {
        userRepository.deleteById(theId);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}*/
