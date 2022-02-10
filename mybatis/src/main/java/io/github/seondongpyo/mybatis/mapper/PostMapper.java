package io.github.seondongpyo.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import io.github.seondongpyo.mybatis.domain.Post;

@Mapper
public interface PostMapper {

	List<Post> findAll();

	Post findById(Long postId);

	void save(Post post);

	void update(Post updatePost);

	void delete(Long postId);

}
