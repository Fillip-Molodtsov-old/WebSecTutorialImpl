package com.mldtsv.amigossecurity.security;

import com.mldtsv.amigossecurity.security.domain.Permissions;
import com.mldtsv.amigossecurity.security.domain.Roles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers( HttpMethod.POST,"/api/v1/user/register").permitAll()
            .antMatchers(HttpMethod.PUT, "/api/v1/management/student/**")
               .hasAuthority(Permissions.STUDENT_WRITE.getAuthority())
           .antMatchers(HttpMethod.POST, "/api/v1/management/student/**")
               .hasAuthority(Permissions.STUDENT_WRITE.getAuthority())
            .antMatchers(HttpMethod.DELETE, "/api/v1/management/student/**")
               .hasAuthority(Permissions.STUDENT_WRITE.getAuthority())
//            .antMatchers("/api/**").hasRole("STUDENT")
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }

    @Bean(name = "pwdEncoder")
    public PasswordEncoder getPasswordEncoder() {
        DelegatingPasswordEncoder delPasswordEncoder = (DelegatingPasswordEncoder)
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        delPasswordEncoder.setDefaultPasswordEncoderForMatches(bcryptPasswordEncoder);
        return delPasswordEncoder;
    }
}
