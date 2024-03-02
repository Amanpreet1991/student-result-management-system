package io.shyftlabs.service.impl;

import io.shyftlabs.entity.Course;
import io.shyftlabs.exceptions.DuplicateEntityException;
import io.shyftlabs.exceptions.EntityNotFoundException;
import io.shyftlabs.repository.CourseRepository;
import io.shyftlabs.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course createCourse(Course course) {
        String courseName = course.getName();
        log.info("Creating course \"{}\" in DB...", courseName);
        if (courseRepository.existsByName(courseName)) {
            throw new DuplicateEntityException("Course with name \"" + courseName + "\" already exists");
        }

        course = courseRepository.save(course);
        log.info("Course created in DB with id {}", course.getId());
        return course;
    }

    public void deleteCourse(Long courseId) {
        log.info("Deleting course with id: {}", courseId);
        Course course = courseRepository.findById(courseId) //
                .orElseThrow(() -> new EntityNotFoundException("No course with ID " + courseId));

        courseRepository.delete(course);
        log.info("Deleted course with id: {}", courseId);
    }

}