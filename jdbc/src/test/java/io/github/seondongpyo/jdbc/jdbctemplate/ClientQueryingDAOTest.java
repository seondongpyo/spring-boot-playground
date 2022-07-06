package io.github.seondongpyo.jdbc.jdbctemplate;

import io.github.seondongpyo.jdbc.dao.ClientQueryingDAO;
import io.github.seondongpyo.jdbc.domain.Client;
import io.github.seondongpyo.jdbc.mapper.ClientRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
class ClientQueryingDAOTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ClientQueryingDAO queryingDAO;

    @BeforeEach
    void setup() {
        queryingDAO = new ClientQueryingDAO(jdbcTemplate, new ClientRowMapper());

        jdbcTemplate.execute("DROP TABLE IF EXISTS clients");
        jdbcTemplate.execute("CREATE TABLE clients" +
            "(id BIGINT PRIMARY KEY, name VARCHAR(255), age SMALLINT)");

        jdbcTemplate.update("INSERT INTO clients(id, name, age) VALUES(1, 'kim', 20)");
        jdbcTemplate.update("INSERT INTO clients(id, name, age) VALUES(2, 'lee', 30)");
    }

    @Test
    void count() {
        List<Client> clients = queryingDAO.findAll();
        assertThat(clients).hasSize(2);
    }
}
