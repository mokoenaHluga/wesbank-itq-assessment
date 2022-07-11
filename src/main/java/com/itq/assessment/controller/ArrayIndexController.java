package com.itq.assessment.controller;

import com.itq.assessment.dto.SumArrayResponse;
import com.itq.assessment.dto.SumRequestDto;
import com.itq.assessment.service.ArrayIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("array")

public class ArrayIndexController {

    private final ArrayIndexService arrayIndexService;

    @Autowired
    public ArrayIndexController(ArrayIndexService arrayIndexService) {
        this.arrayIndexService = arrayIndexService;
    }

    @GetMapping
    public ResponseEntity<SumArrayResponse> getIndexes(@RequestBody SumRequestDto sumRequestDto) {
        SumArrayResponse sumArrayResponse = arrayIndexService.compute(sumRequestDto);
        return new ResponseEntity<>(sumArrayResponse, HttpStatus.OK);
    }
}
