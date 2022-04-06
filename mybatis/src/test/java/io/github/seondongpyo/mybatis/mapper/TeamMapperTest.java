package io.github.seondongpyo.mybatis.mapper;

import io.github.seondongpyo.mybatis.domain.football.Player;
import io.github.seondongpyo.mybatis.domain.football.Team;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
class TeamMapperTest {

    @Autowired
    private TeamMapper teamMapper;

    @DisplayName("외래 키를 통한 연관관계인 경우, JOIN 절을 생략할 수 있다.")
    @Test
    void findById() {
        Team team = teamMapper.findById(1L);
        List<Player> players = team.getPlayers();
        List<String> playerNames = players.stream()
            .map(Player::getName)
            .collect(Collectors.toList());

        assertThat(team.getName()).isEqualTo("Tottenham Hotspur F.C.");
        assertThat(players).hasSize(2);
        assertThat(playerNames).containsExactly("Son Heung-min", "Harry Kane");
    }

}