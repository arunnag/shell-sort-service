package com.shellsort.sortingfloats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.validation.constraints.NotNull;


/**
 * DTO class for list of floats
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class FloatList {
    /**
     * List of floats
     */
    @NotNull
    private List<Float> floats;
}
