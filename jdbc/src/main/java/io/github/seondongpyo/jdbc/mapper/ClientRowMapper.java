package io.github.seondongpyo.jdbc.mapper;

import io.github.seondongpyo.jdbc.domain.Client;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ClientRowMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Client(
            resultSet.getLong("id"),
            resultSet.getString("name"),
            resultSet.getInt("age")
        );
    }
}
