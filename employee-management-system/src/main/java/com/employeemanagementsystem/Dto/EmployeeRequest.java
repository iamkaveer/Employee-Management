package com.employeemanagementsystem.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    @NotBlank(message = "first name should not be blank")
    private String firstName;

    @NotBlank(message = "last name should not be blank")
    private String lastName;

    @Email(message = "invalid email address")
    private String email;

    @Length(min = 10, max = 10, message = "provide valid 10 digits phone number")
    private String phoneNumber;

    private String jobRole;

    private long salary;
}
