package com.nhnacademy.jdbc.board.post.domain;

import com.nhnacademy.jdbc.board.comment.domain.Comment;
import com.nhnacademy.jdbc.board.login.domain.User;
import java.util.Date;
import lombok.Data;

@Data
public class Post {
    private Long postID;
    private User user;
    private Comment comment;
    private String title;
    private String content;
    private Date createdDate;
    private Date updatedDate;
    private Long isDeleted;
}