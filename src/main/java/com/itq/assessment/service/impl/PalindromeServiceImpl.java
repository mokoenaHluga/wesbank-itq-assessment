package com.itq.assessment.service.impl;

import com.itq.assessment.service.PalindromeService;
import org.springframework.stereotype.Service;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    @Override
    public String getPalindrome(String sentence) {
        return longestPalindrome(sentence);
    }

    static String longestPalindrome(String str) {
        str = str + " ";

        String longestWord = "";
        StringBuilder word = new StringBuilder();

        int length;
        int length1 = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != ' ') {
                word.append(ch);
            } else {
                length = word.length();
                if (checkPalindrome(word.toString()) && length > length1) {
                    length1 = length;
                    longestWord = word.toString();
                }
                word = new StringBuilder();
            }
        }

        return longestWord;
    }

    static boolean checkPalindrome(String word) {
        int n = word.length();

        word = word.toLowerCase();

        for (int i = 0; i < n; i++, n--) {
            if (word.charAt(i) != word.charAt(n - 1)) {
                return false;
            }
        }
        return true;
    }
}
