package com.nhnacademy.jdbc.board.comment.mapper;

import com.nhnacademy.jdbc.board.comment.domain.Comment;
import java.util.List;

public interface CommentMapper {
    List<Comment> findAllCommentsByPostID(Long postID);

    int insertComment(Comment comment);
}
