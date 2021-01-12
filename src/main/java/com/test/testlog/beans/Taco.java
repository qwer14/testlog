package com.test.testlog.beans;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author pc
 */
@Data
public class Taco {
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;
    private List<String> ingredients;
}
