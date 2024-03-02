package io.shyftlabs.service;

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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ResultService {

    List<Result> getAllResults();

    Result createResult(ResultRequest resultReq);
}
