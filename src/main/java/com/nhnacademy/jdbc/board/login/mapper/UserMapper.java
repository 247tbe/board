package com.nhnacademy.jdbc.board.login.mapper;

import com.nhnacademy.jdbc.board.login.domain.User;
import java.util.Optional;

public interface UserMapper {
    Optional<User> selectUserByLoginID(String loginID);
}
