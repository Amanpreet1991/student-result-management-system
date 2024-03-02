package io.shyftlabs.mapper;

import io.shyftlabs.controllers.response.ResultResponse;
import io.shyftlabs.entity.Result;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResultMapper {

    ResultResponse map(Result result);

    List<ResultResponse> map(List<Result> results);

}
