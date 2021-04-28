package com.mldtsv.amigossecurity.jwt;

import lombok.Data;

@Data
public class UsernamePasswordAuthRequest {
    private String username;
    private String password;
}
