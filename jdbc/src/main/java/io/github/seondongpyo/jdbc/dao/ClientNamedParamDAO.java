package io.github.seondongpyo.jdbc.dao;

import io.github.seondongpyo.jdbc.domain.Client;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ClientNamedParamDAO {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ClientNamedParamDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public long useMapSqlParameterSource(String name) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("name", name);
        return namedParameterJdbcTemplate.queryForObject("select count(*) from clients where name = :name", namedParameters, Long.class);
    }

    public long useBeanPropertySqlParameterSource(Client client) {
        String sql = "select count(*) from clients where name = :name and age = :age";
        BeanPropertySqlParameterSource beanPropertyParameters = new BeanPropertySqlParameterSource(client);
        return namedParameterJdbcTemplate.queryForObject(sql, beanPropertyParameters, Long.class);
    }
}
