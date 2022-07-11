package com.itq.assessment.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SumRequestDto implements Serializable {
    private Integer target;
    private int [] array;
}
