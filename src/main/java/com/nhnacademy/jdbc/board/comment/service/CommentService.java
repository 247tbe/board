package com.nhnacademy.jdbc.board.comment.service;

import com.nhnacademy.jdbc.board.comment.domain.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> viewCommentsByPostID(Long postID);

    int createComment(Comment comment);
}
