package io.github.seondongpyo.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.github.seondongpyo.jdbc.domain.Client;
import io.github.seondongpyo.jdbc.mapper.ClientRowMapper;

@Repository
public class ClientQueryingDAO {

    private final JdbcTemplate jdbcTemplate;
    private final ClientRowMapper clientRowMapper;

    public ClientQueryingDAO(JdbcTemplate jdbcTemplate, ClientRowMapper clientRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.clientRowMapper = clientRowMapper;
    }

    public List<Client> findAll() {
        return jdbcTemplate.query("select * from clients", clientRowMapper);
    }

    public String getName(long id) {
        return jdbcTemplate.queryForObject("select name from clients where id = ?", String.class, id);
    }

    public Client findById(long id) {
        return jdbcTemplate.queryForObject("select * from clients where id = ?", clientRowMapper, id);
    }
}
