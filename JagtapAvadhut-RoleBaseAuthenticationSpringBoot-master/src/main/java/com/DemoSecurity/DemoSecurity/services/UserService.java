package com.DemoSecurity.DemoSecurity.services;

//import com.DemoSecurity.DemoSecurity.Repository.UserRepository;
import com.DemoSecurity.DemoSecurity.Repository.UsersRepo;
import com.DemoSecurity.DemoSecurity.Entites.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UsersRepo userRepository;

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Users addUser(Users users) {
        return userRepository.save(users);
    }

    public Optional<Object> findByUsername(String username) {
        System.out.println(username);
        return Optional.ofNullable(this.userRepository.findByUsername(username));
    }

    public String userRoleByUserName(String  userName){
        return userRepository.findUserRoleByUsername(userName);
    }


}
