package com.DemoSecurity.DemoSecurity.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MainController")
public class MainController {
    @GetMapping("/name")
//    @PreAuthorize("hasRole('Admin')")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String ControllerName(){
        return "This Is Main Controller";
    }
}
