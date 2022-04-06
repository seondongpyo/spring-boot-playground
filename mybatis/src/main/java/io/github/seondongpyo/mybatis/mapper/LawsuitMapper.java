package io.github.seondongpyo.mybatis.mapper;

import io.github.seondongpyo.mybatis.domain.suit.Lawsuit;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LawsuitMapper {

    Lawsuit findById(Long id);
}
