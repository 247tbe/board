package com.nhnacademy.jdbc.board.login.service;

import com.nhnacademy.jdbc.board.login.domain.User;
import java.util.Optional;

public interface UserLoginService {
    User login(String loginID, String password);

    Optional<User> getUserID(String loginID);

}
