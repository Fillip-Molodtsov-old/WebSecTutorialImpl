package com.mldtsv.amigossecurity.repository.impl;

import com.mldtsv.amigossecurity.config.PostgresQueries;
import com.mldtsv.amigossecurity.domain.User;
import com.mldtsv.amigossecurity.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Optional;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDAO {

    private PostgresQueries postgresQueries;
    private DataSource dataSource;

    @Autowired
    public UserDaoImpl(PostgresQueries postgresQueries, DataSource dataSource) {
        this.postgresQueries = postgresQueries;
        setDataSource(dataSource);
    }

    @Override
    public Optional<User> findById(String id) {
        Optional<User> user;
        try{
            user = Optional.ofNullable(getJdbcTemplate().queryForObject(postgresQueries.getGetUserByUsername(),(rs, row) ->
                    new User(rs.getString("user_id"),
                            rs.getString("password"),
                            rs.getString("role")),
                    id));
        } catch (EmptyResultDataAccessException e) {
            user = Optional.empty();
        }
        return user;
    }

    @Override
    public Collection<User> getAll() {

        return null;
    }

    @Override
    public void create(User item) {
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(postgresQueries.getCreateUser(),
                item.getUsername(),item.getPassword(), item.getRole());
    }

    @Override
    public void update(String id, User item) {

    }

    @Override
    public void delete(String id) {

    }
}
