package io.github.seondongpyo.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import io.github.seondongpyo.mybatis.domain.Member;

@Mapper
public interface MemberMapper {

	@Select("select * from Member")
	List<Member> findAll();

	@Select("select * from Member where member_id = #{memberId}")
	Member findById(@Param("memberId") Long memberId);

	@Insert("insert into Member(name, age) values (#{name}, #{age})")
	@Options(useGeneratedKeys = true, keyProperty = "memberId")
	void save(Member member);

	@Update("update Member set name = #{name}, age = #{age} where member_id = #{memberId}")
	void update(Member updateMember);

	@Delete("delete from Member where member_id = #{id}")
	void delete(Long memberId);

}
