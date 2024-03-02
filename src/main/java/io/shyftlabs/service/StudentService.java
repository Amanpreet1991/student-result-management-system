package io.shyftlabs.service;

import io.shyftlabs.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student createStudent(Student student);

    void deleteStudent(Long studentId);
}
