package io.github.seondongpyo.mybatis.domain.football;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Team {

    private Long id;
    private String name;
    private List<Player> players;
}
