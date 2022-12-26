package com.nhnacademy.jdbc.board.post.mapper;

import com.nhnacademy.jdbc.board.post.domain.Post;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface PostMapper {
    List<Post> viewPostList();

    Post findByID(long id);

    @Transactional
    int insertPost(String title, String content);

    int modifyPost(Post post);

    int deletePost(Post post);
}
