package com.mldtsv.amigossecurity.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "custom.postgres")
public class PostgresQueries {
    private String getStudentById;
    private String getAllStudents;
    private String createStudent;
    private String updateStudent;
    private String deleteStudent;
    private String getUserByUsername;
    private String createUser;
}
