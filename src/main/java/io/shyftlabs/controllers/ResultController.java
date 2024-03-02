package io.shyftlabs.controllers;

import io.shyftlabs.controllers.request.ResultRequest;
import io.shyftlabs.controllers.response.ResultResponse;
import io.shyftlabs.entity.Result;
import io.shyftlabs.mapper.ResultMapper;
import io.shyftlabs.service.ResultService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
@Slf4j
@Tag(name = "Results", description = "Results for Students' courses")
public class ResultController {

    private ResultService resultService;

    private ResultMapper resultMapper;

    public ResultController(ResultService resultService, ResultMapper resultMapper) {
        this.resultService = resultService;
        this.resultMapper = resultMapper;
    }

    @Operation(summary = "Get all Results")
    @GetMapping
    public ResponseEntity<List<ResultResponse>> getAllResults() {
        List<Result> results = resultService.getAllResults();
        log.info("{} results pulled from DB", results.size());
        List<ResultResponse> resources = resultMapper.map(results);
        return ResponseEntity.status(HttpStatus.OK).body(resources);
    }

    @Operation(summary = "Create a new Result")
    @PostMapping
    public ResponseEntity<ResultResponse> addCourse(@Valid @RequestBody ResultRequest resultReq) {
        Result result = resultService.createResult(resultReq);
        ResultResponse createdResource = resultMapper.map(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResource);
    }

}
