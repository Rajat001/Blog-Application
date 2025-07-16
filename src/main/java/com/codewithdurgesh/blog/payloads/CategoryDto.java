package com.codewithdurgesh.blog.payloads;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDto {

    private Integer categoryId;

    @NotEmpty
    @Size(message = "Title Can't be empty !!! ")
    private String categoryTitle;

    @NotEmpty
    @Size(message = "Description Can't be empty !!! ")
    private String categoryDescription;
}
