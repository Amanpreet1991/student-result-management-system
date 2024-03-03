package io.shyftlabs.controllers.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.shyftlabs.validators.ValidDateOfBirth;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentRequest {

    @NotBlank(message = "First name cannot be blank")
    @Size(max = 50, message = "First name cannot be longer than 50 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(max = 50, message = "Last name cannot be longer than 50 characters")
    private String lastName;

    @Size(max = 100, message = "Email cannot be longer than 100 characters")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Email is not valid")
    private String email;

    @ValidDateOfBirth(message = "Student must be at least 10 years old")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy", timezone = "America/Toronto")
    private Date dateOfBirth;

}
