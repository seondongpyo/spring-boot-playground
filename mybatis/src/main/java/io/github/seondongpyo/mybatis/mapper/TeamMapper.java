package io.github.seondongpyo.mybatis.mapper;

import io.github.seondongpyo.mybatis.domain.football.Team;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamMapper {

    Team findById(Long id);
}
