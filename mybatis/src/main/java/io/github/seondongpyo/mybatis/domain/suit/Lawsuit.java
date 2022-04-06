package io.github.seondongpyo.mybatis.domain.suit;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Lawsuit {

    private Long id;
    private String name;
    private List<Client> clients;
}
