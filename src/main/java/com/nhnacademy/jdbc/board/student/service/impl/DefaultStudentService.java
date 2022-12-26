package com.nhnacademy.jdbc.board.student.service.impl;

import com.nhnacademy.jdbc.board.student.domain.Student;
import com.nhnacademy.jdbc.board.student.mapper.StudentMapper;
import com.nhnacademy.jdbc.board.student.service.StudentService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DefaultStudentService implements StudentService {
    private final StudentMapper studentMapper;

    public DefaultStudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public Optional<Student> getStudent(long id) {
        return studentMapper.selectStudent(id);
    }
}
