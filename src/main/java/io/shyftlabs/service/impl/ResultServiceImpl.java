package io.shyftlabs.service.impl;

import io.shyftlabs.controllers.request.ResultRequest;
import io.shyftlabs.entity.Course;
import io.shyftlabs.entity.Result;
import io.shyftlabs.entity.Score;
import io.shyftlabs.entity.Student;
import io.shyftlabs.exceptions.DuplicateEntityException;
import io.shyftlabs.exceptions.EntityNotFoundException;
import io.shyftlabs.repository.CourseRepository;
import io.shyftlabs.repository.ResultRepository;
import io.shyftlabs.repository.StudentRepository;
import io.shyftlabs.service.ResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ResultServiceImpl implements ResultService {

    private ResultRepository resultRepository;

    private CourseRepository courseRepository;

    private StudentRepository studentRepository;

    public ResultServiceImpl(ResultRepository resultRepository, CourseRepository courseRepository, StudentRepository studentRepository) {
        this.resultRepository = resultRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    public Result createResult(ResultRequest resultReq) {
        long courseId = resultReq.getCourseId();
        long studentId = resultReq.getStudentId();

        log.info("Creating a Result in DB with studentId: {} and courseId: {}", courseId, studentId);
        if (resultRepository.existsByCourseIdAndStudentId(courseId, studentId)) {
            throw new DuplicateEntityException("Result already exists for course " + courseId + " and student " + studentId);
        }

        Course course = courseRepository.findById(courseId) //
                .orElseThrow(() -> new EntityNotFoundException("No course with ID " + courseId));

        Student student = studentRepository.findById(studentId) //
                .orElseThrow(() -> new EntityNotFoundException("No student with ID " + studentId));

        Result result = new Result();
        result.setCourse(course);
        result.setStudent(student);
        result.setScore(Score.value(resultReq.getScore()));

        result = resultRepository.save(result);
        log.info("Result Id {} created in DB", result.getId());
        return result;
    }

}
