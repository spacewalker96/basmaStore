package com.store.basma.controller;


import com.store.basma.enity.User;
import com.store.basma.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {



    private UserService userService;

    @Autowired
    public UserController(UserService theUserService) {
        userService = theUserService;
    }



    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {

        User theUser = userService.findById(userId);

//        if (theUser == null) {
//            throw new RuntimeException("User id not found - " + userId);
//        }

        return theUser;
    }


    @PostMapping("/users")
    public User addUser(@RequestBody User theUser) {
      theUser.setId(0L);
        userService.save(theUser);
        return theUser;
    }


    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {

        userService.save(theUser);

        return theUser;
    }


    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        User tempUser = userService.findById(userId);


 if (tempUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }


        userService.deleteById(userId);

        return "Deleted user id - " + userId;
    }
}

/*@RestController
@RequestMapping("/users") //localhost:8086/users
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public  User creatUser(@RequestBody  User userRequest) {
       // UserDato userDto = new UserDato();
        ///affecte from userRequest ti userDtao
        //BeanUtils.copyProperties(userRequest, userDto);
        ////send formation vr service
        UserDato creatUser = userService.creatUser(userDto);
        ////create response
        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(creatUser, userResponse);

        return userResponse;
    }

    @PutMapping
    public String updateUser() {
        return "update  user was called";
    }

    @DeleteMapping
    public String deletUser() {
        return "delet user was called";
    }

}*/
