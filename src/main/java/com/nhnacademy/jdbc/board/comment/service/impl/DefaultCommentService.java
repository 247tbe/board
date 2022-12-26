package com.nhnacademy.jdbc.board.comment.service.impl;

import com.nhnacademy.jdbc.board.comment.domain.Comment;
import com.nhnacademy.jdbc.board.comment.mapper.CommentMapper;
import com.nhnacademy.jdbc.board.comment.service.CommentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DefaultCommentService implements CommentService {
    private final CommentMapper commentMapper;

    public DefaultCommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> viewCommentsByPostID(Long postID) {
        return commentMapper.findAllCommentsByPostID(postID);
    }

    @Override
    public int createComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

}
