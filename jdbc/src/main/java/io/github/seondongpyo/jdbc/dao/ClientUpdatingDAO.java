package io.github.seondongpyo.jdbc.dao;

import io.github.seondongpyo.jdbc.domain.Client;
import org.springframework.jdbc.core.JdbcTemplate;

public class ClientUpdatingDAO {

    private final JdbcTemplate jdbcTemplate;

    public ClientUpdatingDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Client client) {
        jdbcTemplate.update("INSERT INTO clients(id, name, age) VALUES(?, ?, ?)",
            client.getId(), client.getName(), client.getAge());
    }

    public void update(Client updateParam) {
        jdbcTemplate.update("UPDATE clients SET name = ?, age = ? WHERE id = ?",
            updateParam.getName(), updateParam.getAge(), updateParam.getId());
    }
}
