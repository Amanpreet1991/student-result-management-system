package io.shyftlabs.mapper;

import io.shyftlabs.controllers.request.CourseRequest;
import io.shyftlabs.controllers.response.CourseResponse;
import io.shyftlabs.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course map(CourseRequest request);

    CourseResponse map(Course course);

    List<CourseResponse> map(List<Course> courses);
}