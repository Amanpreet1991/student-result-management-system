package io.shyftlabs.controllers;

import io.shyftlabs.controllers.request.CourseRequest;
import io.shyftlabs.controllers.response.CourseResponse;
import io.shyftlabs.entity.Course;
import io.shyftlabs.mapper.CourseMapper;
import io.shyftlabs.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Slf4j
@Tag(name = "Courses", description = "Course API Section")
public class CourseController {

    private CourseService courseService;

    private CourseMapper courseMapper;

    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @Operation(summary = "Get all courses")
    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        log.info("{} courses pulled from DB", courses.size());
        List<CourseResponse> resources = courseMapper.map(courses);
        return ResponseEntity.status(HttpStatus.OK).body(resources);
    }

    @Operation(summary = "Create a course")
    @PostMapping
    public ResponseEntity<CourseResponse> createCourse(@Valid @RequestBody CourseRequest courseReq) {
        Course course = courseMapper.map(courseReq);
        course = courseService.createCourse(course);
        CourseResponse createdResource = courseMapper.map(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResource);
    }

    @Operation(summary = "Delete a course")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
