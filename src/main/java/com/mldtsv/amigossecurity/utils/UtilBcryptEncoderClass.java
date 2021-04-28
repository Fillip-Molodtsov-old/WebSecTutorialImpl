package com.mldtsv.amigossecurity.utils;

import com.mldtsv.amigossecurity.security.domain.Roles;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UtilBcryptEncoderClass {
    public static void main(String a[]) {
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String pwd = bcryptPasswordEncoder.encode("");
        System.out.println(pwd);
    }
}
