package io.github.seondongpyo.jdbc.dao;

import io.github.seondongpyo.jdbc.domain.Client;
import io.github.seondongpyo.jdbc.mapper.ClientRowMapper;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientQueryingDAO {

    private final JdbcTemplate jdbcTemplate;
    private final ClientRowMapper clientRowMapper;

    public ClientQueryingDAO(JdbcTemplate jdbcTemplate, ClientRowMapper clientRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.clientRowMapper = clientRowMapper;
    }

    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from clients", Long.class);
    }

    public String getName(long id) {
        return jdbcTemplate.queryForObject("select name from clients where id = ?", String.class, id);
    }

    public Client findById(long id) {
        List<Client> clients = jdbcTemplate.query("select * from clients where id = ?", clientRowMapper, id);
        return DataAccessUtils.singleResult(clients);
    }

    public List<Client> findAllClients() {
        return jdbcTemplate.query("select * from clients", clientRowMapper);
    }

    public Client findByName(String name) {
        return jdbcTemplate.queryForObject("select * from clients where name = ?", clientRowMapper, name);
    }
}
