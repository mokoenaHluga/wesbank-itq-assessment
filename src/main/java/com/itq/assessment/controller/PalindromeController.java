package com.itq.assessment.controller;

import com.itq.assessment.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("palindrome")
public class PalindromeController {
    private final PalindromeService palindromeService;

    @Autowired
    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @GetMapping("{data}")
    public ResponseEntity<String> getPalindrome(@PathVariable("data") String data){
        String palindrome = palindromeService.getPalindrome(data);
        return new ResponseEntity<>(palindrome, HttpStatus.OK);
    }
}
