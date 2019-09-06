package com.angularspring.mvn.springbackendrest;

import java.security.Principal;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository userRepository;
    
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        //System.out.println(user);
        userRepository.save(user);
    }

    @RequestMapping("/auth")
    public Principal user(Principal user){
        return user;
    }

}