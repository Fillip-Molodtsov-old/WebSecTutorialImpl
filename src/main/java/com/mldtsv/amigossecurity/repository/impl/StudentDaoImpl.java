package com.mldtsv.amigossecurity.repository.impl;

import com.mldtsv.amigossecurity.config.PostgresQueries;
import com.mldtsv.amigossecurity.domain.Student;
import com.mldtsv.amigossecurity.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Collection;
import java.util.Optional;

@Repository
public class StudentDaoImpl extends JdbcDaoSupport implements StudentDAO {

    private PostgresQueries postgresQueries;
    private DataSource dataSource;

    private final static RowMapper<Student> studentRowMapper = (rs, row) ->
                    new Student(rs.getInt("student_id"), rs.getString("name"));

    @Autowired
    public StudentDaoImpl(PostgresQueries postgresQueries, DataSource dataSource) {
        this.postgresQueries = postgresQueries;
        setDataSource(dataSource);
    }

    @Override
    public Optional<Student> findById(Integer id) {
        Optional<Student> st;
        try{
            st = Optional.ofNullable(getJdbcTemplate().queryForObject(postgresQueries.getGetStudentById(),
                    studentRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            st = Optional.empty();
        }
        return st;
    }

    @Override
    public Collection<Student> getAll() {
        assert getJdbcTemplate() != null;
        return getJdbcTemplate().query(postgresQueries.getGetAllStudents(),studentRowMapper);
    }

    @Override
    public void create(Student item) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(postgresQueries.getCreateStudent(), item.getName());
    }

    @Override
    public void update(Integer id, Student item) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(postgresQueries.getUpdateStudent(), item.getName(), id);
    }

    @Override
    public void delete(Integer id) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(postgresQueries.getDeleteStudent(), id);
    }
}
