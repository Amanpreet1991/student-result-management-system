package io.shyftlabs.controllers;

import io.shyftlabs.controllers.request.StudentRequest;
import io.shyftlabs.controllers.response.StudentResponse;
import io.shyftlabs.entity.Student;
import io.shyftlabs.mapper.StudentMapper;
import io.shyftlabs.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
@Tag(name = "Students", description = "Students API Section")
public class StudentController {

    private StudentService studentService;

    private StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        log.info("Found {} students in DB", students.size());
        List<StudentResponse> resources = studentMapper.map(students);
        return ResponseEntity.status(HttpStatus.OK).body(resources);
    }

    @Operation(summary = "Create a student")
    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest studentReq) {
        Student student = studentMapper.map(studentReq);
        student = studentService.createStudent(student);
        StudentResponse createdResource = studentMapper.map(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResource);
    }

    @Operation(summary = "Delete a student")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
