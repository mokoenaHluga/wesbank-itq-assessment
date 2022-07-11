package com.itq.assessment.service.impl;

import com.itq.assessment.dto.SumArrayResponse;
import com.itq.assessment.dto.SumRequestDto;
import com.itq.assessment.service.ArrayIndexService;
import org.springframework.stereotype.Service;

@Service
public class ArrayIndexServiceImpl implements ArrayIndexService {

    @Override
    public SumArrayResponse compute(SumRequestDto sumRequestDto) {
        SumArrayResponse sumArrayResponse = new SumArrayResponse();
        int target = sumRequestDto.getTarget();
        int[] response = computeTarget(sumRequestDto.getArray(), target);

        if (response.length > 0) {
            sumArrayResponse.setIndexArray(response);
        } else {
            sumArrayResponse.setMessage("No indexes adding up to target value");
        }

        return sumArrayResponse;
    }

    private int[] computeTarget(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }
}
