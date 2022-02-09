package io.github.seondongpyo.mybatis.mapper;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.seondongpyo.mybatis.domain.Member;

@MybatisTest
class MemberMapperTest {

	@Autowired
	MemberMapper memberMapper;

	@Test
	void findAll() {
		List<Member> members = memberMapper.findAll();
		assertThat(members).hasSize(2);
	}

	@Test
	void findById() {
		Member member = memberMapper.findById(1L);
		assertThat(member.getName()).isEqualTo("홍길동");
		assertThat(member.getAge()).isEqualTo(20);
	}
}