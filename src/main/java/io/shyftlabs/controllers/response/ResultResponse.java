package io.shyftlabs.controllers.response;

import io.shyftlabs.entity.Score;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResultResponse {

    private Long id;

    private Score score;

    private CourseResponse course;

    private StudentResponse student;
}
