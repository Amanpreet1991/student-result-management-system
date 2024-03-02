package io.shyftlabs.repository;

import io.shyftlabs.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    boolean existsByCourseIdAndStudentId(Long courseId, Long studentId);

}
