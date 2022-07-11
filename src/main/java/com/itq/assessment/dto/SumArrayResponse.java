package com.itq.assessment.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SumArrayResponse implements Serializable {
    private String message;
    private int [] indexArray;
}
