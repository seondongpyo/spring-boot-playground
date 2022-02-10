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

	@Test
	void save() {
		Member member = new Member("김철수", 25);
		memberMapper.save(member);
		assertThat(member.getId()).isEqualTo(3);
	}

	@Test
	void update() {
		Long memberId = 1L;
		Member member = memberMapper.findById(memberId);
		member.setName("고길동");
		member.setAge(50);
		memberMapper.update(member);

		Member updatedMember = memberMapper.findById(memberId);
		assertThat(updatedMember.getName()).isEqualTo("고길동");
		assertThat(updatedMember.getAge()).isEqualTo(50);
	}

	@Test
	void delete() {
		memberMapper.delete(1L);

		List<Member> members = memberMapper.findAll();
		assertThat(members).hasSize(1);
	}
}
