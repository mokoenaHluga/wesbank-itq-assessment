package com.itq.assessment.service;

import com.itq.assessment.dto.SumArrayResponse;
import com.itq.assessment.service.impl.ArrayIndexServiceImpl;
import com.itq.assessment.test.data.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ArrayIndexServiceImpl.class)
public class ArrayIndexServiceImplTest {
    @Autowired
    private ArrayIndexService arrayIndexService;

    @Test
    public void testSuccessfulIndexArrayResponse(){
        SumArrayResponse res = arrayIndexService.compute(TestData.getSumRequest(9, new int[]{2, 7, 11, 15}));
        Assert.assertArrayEquals(res.getIndexArray(), new int[]{0, 1});
    }
}
