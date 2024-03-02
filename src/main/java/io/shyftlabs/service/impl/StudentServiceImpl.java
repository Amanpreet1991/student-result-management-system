package io.shyftlabs.service.impl;

import io.shyftlabs.entity.Student;
import io.shyftlabs.exceptions.DuplicateEntityException;
import io.shyftlabs.exceptions.EntityNotFoundException;
import io.shyftlabs.repository.StudentRepository;
import io.shyftlabs.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        String studentEmail = student.getEmail();
        log.info("Creating a student having email \"{}\" in DB", studentEmail);
        if (studentRepository.existsByEmail(studentEmail)) {
            throw new DuplicateEntityException("Student with email \"" + studentEmail + "\" already exists");
        }

        student = studentRepository.save(student);
        log.info("Student with id {} created in DB.", student.getId());
        return student;
    }

    public void deleteStudent(Long studentId) {
        log.info("Deleting studentId: {}", studentId);
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("No student with ID " + studentId));

        studentRepository.delete(student);
        log.info("StudentId: {} deleted from DB.", studentId);
    }
}
