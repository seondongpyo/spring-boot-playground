package io.github.seondongpyo.mybatis.domain.football;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private Long id;
    private Long teamId;
    private String name;
    private String position;
}
