package io.github.seondongpyo.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Post {

	private Long id;
	private String writer;
	private String title;
	private String content;

	public Post(String writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
}
