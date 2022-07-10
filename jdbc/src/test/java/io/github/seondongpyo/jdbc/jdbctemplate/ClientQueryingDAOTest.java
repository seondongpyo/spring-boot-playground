package io.github.seondongpyo.jdbc.jdbctemplate;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import io.github.seondongpyo.jdbc.dao.ClientQueryingDAO;
import io.github.seondongpyo.jdbc.domain.Client;
import io.github.seondongpyo.jdbc.mapper.ClientRowMapper;

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
        long count = queryingDAO.count();
        assertThat(count).isEqualTo(2);
    }

    @Test
    void getName() {
        String name = queryingDAO.getName(1L);
        assertThat(name).isEqualTo("kim");
    }

    @Test
    void findClientById() {
        Client client = queryingDAO.findById(1L);
        assertThat(client).isNotNull();
        assertThat(client.getName()).isEqualTo("kim");
        assertThat(client.getAge()).isEqualTo(20);
    }

    @Test
    void findAllClients() {
        List<Client> clients = queryingDAO.findAllClients();
        assertThat(clients).hasSize(2);
    }
}
