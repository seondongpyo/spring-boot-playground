package io.github.seondongpyo.jdbc.jdbctemplate;

import io.github.seondongpyo.jdbc.dao.ClientQueryingDAO;
import io.github.seondongpyo.jdbc.dao.ClientUpdatingDAO;
import io.github.seondongpyo.jdbc.domain.Client;
import io.github.seondongpyo.jdbc.mapper.ClientRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
class ClientUpdatingDAOTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ClientUpdatingDAO updatingDAO;
    private ClientQueryingDAO queryingDAO;

    @BeforeEach
    void setup() {
        updatingDAO = new ClientUpdatingDAO(jdbcTemplate);
        queryingDAO = new ClientQueryingDAO(jdbcTemplate, new ClientRowMapper());

        jdbcTemplate.execute("DROP TABLE IF EXISTS clients");
        jdbcTemplate.execute("CREATE TABLE clients" +
            "(id BIGINT PRIMARY KEY, name VARCHAR(255), age SMALLINT)");
    }

    @Test
    void insert() {
        Client client = new Client(1L, "hong", 20);
        updatingDAO.insert(client);

        Client foundClient = queryingDAO.findById(1L);

        assertThat(foundClient.getName()).isEqualTo("hong");
        assertThat(foundClient.getAge()).isEqualTo(20);
    }
}
