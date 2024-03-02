package io.shyftlabs.mapper;

import io.shyftlabs.controllers.request.StudentRequest;
import io.shyftlabs.controllers.response.StudentResponse;
import io.shyftlabs.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student map(StudentRequest request);

    StudentResponse map(Student student);

    List<StudentResponse> map(List<Student> students);
}
