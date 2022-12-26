package com.nhnacademy.jdbc.board.comment.domain;

import com.nhnacademy.jdbc.board.login.domain.User;
import com.nhnacademy.jdbc.board.post.domain.Post;
import java.util.Date;
import lombok.Data;

@Data
public class Comment {
    private Long commentID;
    private Long postID;
    private Long userID;
    private String content;
    private Date createdDate;
    private Long count;
    private Post post;
    private User user;
}
