package com.nhnacademy.jdbc.board.post.service;

import com.nhnacademy.jdbc.board.post.domain.Post;
import java.util.List;

public interface PostService {
    List<Post> viewPosts();

    Post findPost(long id);

    int createPost(String title, String content);

    int updatePost(Post post);

    int deletePost(Post post);
}
