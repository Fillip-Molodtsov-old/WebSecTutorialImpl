package com.mldtsv.amigossecurity.web;

import com.mldtsv.amigossecurity.domain.User;
import com.mldtsv.amigossecurity.security.domain.Roles;
import com.mldtsv.amigossecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public UserController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostMapping("/register")
    public void saveUser(@RequestBody User user) {
        var role = user.getRole() != null ? user.getRole() : Roles.STUDENT.name();
        var newUser = new User(user.getUsername(),
                passwordEncoder.encode(user.getPassword()), role);
        userService.createUser(newUser);
    }
}
