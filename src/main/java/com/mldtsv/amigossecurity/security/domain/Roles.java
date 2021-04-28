package com.mldtsv.amigossecurity.security.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public enum Roles {
    STUDENT(new HashSet<>()),
    ADMIN(new HashSet<>(Arrays.asList(
            Permissions.STUDENT_READ,
            Permissions.STUDENT_WRITE,
            Permissions.COURSE_READ,
            Permissions.COURSE_WRITE
    )));

    private Set<GrantedAuthority> permissions;
}
