package io.github.seondongpyo.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import io.github.seondongpyo.mybatis.domain.Member;

@Mapper
public interface MemberMapper {

	@Select("select * from Member")
	List<Member> findAll();

	@Select("select * from Member where id = #{id}")
	Member findById(@Param("id") Long id);

}
