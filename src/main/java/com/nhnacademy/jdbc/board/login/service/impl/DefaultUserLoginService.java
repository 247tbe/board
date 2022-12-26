package com.nhnacademy.jdbc.board.login.service.impl;

import com.nhnacademy.jdbc.board.login.domain.User;
import com.nhnacademy.jdbc.board.login.mapper.UserMapper;
import com.nhnacademy.jdbc.board.login.service.UserLoginService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserLoginService implements UserLoginService {
    private final UserMapper userMapper;

    public DefaultUserLoginService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(String loginID, String password) {
        return userMapper.selectUserByLoginID(loginID)
            .filter(u -> u.getPassword().equals(password))
            .orElse(null);
    }

    @Override
    public Optional<User> getUserID(String loginID) {
        return userMapper.selectUserByLoginID(loginID);
    }
}
