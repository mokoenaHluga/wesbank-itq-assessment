package com.itq.assessment.service;

import com.itq.assessment.service.impl.PalindromeServiceImpl;
import com.itq.assessment.test.data.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PalindromeServiceImpl.class)
public class PalindromeServiceImplTest {
    @Autowired
    private PalindromeService palindromeService;

    @Test
    public void getLongestPalindrome(){

        String expectedResult = "2112";
        String longestPalindrome = palindromeService.getPalindrome(TestData.palindromeTestData);

        Assert.assertEquals(longestPalindrome, expectedResult);
    }
}
