package com.codewithdurgesh.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private int id;

    @NotEmpty
    @Size(min=4, message = "Username must be min of 4 characters !!!")
    private String name;

    @Email(message = "Email address is not valid !!!") // using this we are able to get message for error handling
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10 , message = "Password must be min of 3 chars and max of 10 chars !!")
    private String password;

    @NotEmpty
    private String about;
}
