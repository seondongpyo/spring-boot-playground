package io.github.seondongpyo.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {

	private Long memberId;
	private String name;
	private int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
