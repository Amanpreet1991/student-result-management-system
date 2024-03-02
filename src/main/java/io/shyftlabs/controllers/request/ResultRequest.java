package io.shyftlabs.controllers.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.shyftlabs.entity.Score;
import io.shyftlabs.validators.ValueOfEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultRequest {

    @NotNull(message = "'Student' not specified")
    private Long studentId;

    @NotNull(message = "'Course' not specified")
    private Long courseId;

    @ValueOfEnum(enumClass = Score.class)
    private String score;
}
