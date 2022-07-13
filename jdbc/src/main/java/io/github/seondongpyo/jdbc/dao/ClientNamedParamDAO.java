package io.github.seondongpyo.jdbc.dao;

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
}
