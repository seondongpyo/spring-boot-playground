package io.github.seondongpyo.jdbc.jdbctemplate;

import io.github.seondongpyo.jdbc.dao.ClientNamedParamDAO;
import io.github.seondongpyo.jdbc.dao.ClientQueryingDAO;
import io.github.seondongpyo.jdbc.domain.Client;
import io.github.seondongpyo.jdbc.mapper.ClientRowMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.assertj.core.api.Assertions.*;

@JdbcTest
class ClientNamedParamDAOTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private ClientNamedParamDAO namedParamDAO;

    @BeforeEach
    void setup() {
        namedParamDAO = new ClientNamedParamDAO(namedParameterJdbcTemplate);

        jdbcTemplate.execute("DROP TABLE IF EXISTS clients");
        jdbcTemplate.execute("CREATE TABLE clients" +
            "(id BIGINT PRIMARY KEY, name VARCHAR(255), age SMALLINT)");

        jdbcTemplate.update("INSERT INTO clients(id, name, age) VALUES(1, 'kim', 20)");
        jdbcTemplate.update("INSERT INTO clients(id, name, age) VALUES(2, 'kim', 25)");
        jdbcTemplate.update("INSERT INTO clients(id, name, age) VALUES(3, 'lee', 30)");
    }

    @Test
    void useMapSqlParameterSource() {
        long count = namedParamDAO.useMapSqlParameterSource("kim");
        assertThat(count).isEqualTo(2);
    }

    @Test
    void useBeanPropertySqlParameterSource() {
        long count = namedParamDAO.useBeanPropertySqlParameterSource(new Client(1L, "kim", 20));
        assertThat(count).isEqualTo(1);
    }
}
