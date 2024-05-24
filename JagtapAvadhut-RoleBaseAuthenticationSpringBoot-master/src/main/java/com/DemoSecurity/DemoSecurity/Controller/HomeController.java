package com.DemoSecurity.DemoSecurity.Controller;

import com.DemoSecurity.DemoSecurity.Entites.Users;
import com.DemoSecurity.DemoSecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Users> getUser() {
        return this.userService.getUsers();
    }
}
