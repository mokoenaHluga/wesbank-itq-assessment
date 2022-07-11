package com.itq.assessment.service;

import com.itq.assessment.dto.SumArrayResponse;
import com.itq.assessment.dto.SumRequestDto;

public interface ArrayIndexService {
    SumArrayResponse compute(SumRequestDto sumRequestDto);
}
