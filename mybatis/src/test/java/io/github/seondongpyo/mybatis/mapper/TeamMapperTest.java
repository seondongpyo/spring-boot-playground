package io.github.seondongpyo.mybatis.mapper;

import io.github.seondongpyo.mybatis.domain.football.Team;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
class TeamMapperTest {

    @Autowired
    private TeamMapper teamMapper;

    @Test
    void findById() {
        Team team = teamMapper.findById(1L);
        assertThat(team.getName()).isEqualTo("Tottenham Hotspur F.C.");
    }

}