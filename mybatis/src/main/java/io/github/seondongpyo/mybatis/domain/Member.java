package io.github.seondongpyo.mybatis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

	private Long id;
	private String name;
	private int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
