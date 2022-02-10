package io.github.seondongpyo.mybatis.mapper;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.seondongpyo.mybatis.domain.Post;

@MybatisTest
class PostMapperTest {

	@Autowired
	PostMapper postMapper;

	@Test
	void findAll() {
		List<Post> posts = postMapper.findAll();
		assertThat(posts).hasSize(2);
	}

	@Test
	void findById() {
		Post post = postMapper.findById(1L);
		assertThat(post.getWriter()).isEqualTo("kim");
		assertThat(post.getTitle()).isEqualTo("title1");
		assertThat(post.getContent()).isEqualTo("content1");
	}

	@Test
	void save() {
		postMapper.save(new Post("lee", "title3", "content3"));

		List<Post> posts = postMapper.findAll();
		assertThat(posts).hasSize(3);
	}

	@Test
	void update() {
		Post post = postMapper.findById(1L);
		post.setWriter("hong");
		post.setTitle("title4");
		post.setContent("content4");
		postMapper.update(post);

		Post updatedPost = postMapper.findById(1L);
		assertThat(updatedPost.getWriter()).isEqualTo("hong");
		assertThat(updatedPost.getTitle()).isEqualTo("title4");
		assertThat(updatedPost.getContent()).isEqualTo("content4");
	}

	@Test
	void delete() {
		postMapper.delete(1L);

		List<Post> posts = postMapper.findAll();
		assertThat(posts).hasSize(1);
	}
}