package com.mldtsv.amigossecurity.service;

import com.mldtsv.amigossecurity.domain.User;
import com.mldtsv.amigossecurity.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private UserDAO userDaoImpl;

    @Autowired
    public UserService(UserDAO userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDaoImpl
                .findById(s)
                .orElseThrow(() -> new UsernameNotFoundException("Username not Found"));
    }

    public void createUser(User user) { userDaoImpl.create(user);}
}
