package com.nhnacademy.jdbc.board.post.service.impl;

import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.mapper.PostMapper;
import com.nhnacademy.jdbc.board.post.service.PostService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultPostService implements PostService {
    private final PostMapper postMapper;

    public DefaultPostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public List<Post> viewPosts() {
        return postMapper.viewPostList();
    }

    @Override
    public Post findPost(long id) {
        return postMapper.findByID(id);
    }

    @Override
    public int createPost(String title, String content) {
        return postMapper.insertPost(title, content);
    }

    @Override
    public int updatePost(Post post) {
        return postMapper.modifyPost(post);
    }

    @Override
    public int deletePost(Post post) {
        return postMapper.deletePost(post);
    }
}
