package com.nhnacademy.jdbc.board.student.service;

import com.nhnacademy.jdbc.board.student.domain.Student;
import java.util.Optional;

public interface StudentService {
    Optional<Student> getStudent(long id);
}
