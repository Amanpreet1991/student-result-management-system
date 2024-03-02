package io.shyftlabs.controllers.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseRequest {

    @NotBlank(message = "Course cannot be blank")
    @Size(max = 128, message = "Course name cannot be longer than 128 characters")
    private String name;

}
