package com.nhnacademy.jdbc.board.login.domain;

import java.util.Date;
import lombok.Data;

@Data
public class User {
    private Long userID;
    private String loginID;
    private String password;
    private String userName;
    private Date createdDate;
}
