package io.shyftlabs.service;

import io.shyftlabs.entity.Course;
import io.shyftlabs.exceptions.DuplicateEntityException;
import io.shyftlabs.exceptions.EntityNotFoundException;
import io.shyftlabs.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course createCourse(Course course);

    void deleteCourse(Long courseId);

}
