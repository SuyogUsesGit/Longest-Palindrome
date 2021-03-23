package com.app.longestpalindrome.controller;

import com.app.longestpalindrome.bean.Palindrome;
import com.app.longestpalindrome.exception.InvalidStringException;
import com.app.longestpalindrome.repository.PalindromeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LongestPalindromeController {

    @Autowired
    private PalindromeRepo palindromeRepo;

    @GetMapping("/longest-palindrome/getPalindrome/{inputStr}")
    public ResponseEntity<Palindrome> getLongestPalindrome(@PathVariable String inputStr) {
        if(inputStr == null || inputStr.length() < 2 || inputStr.length() > 1000) {
            throw new InvalidStringException("Please enter a valid string.");
        }
        String result = "";
        for(int i=0; i<inputStr.length(); i++) {
            for(int j=inputStr.length()-1; j>i; j--) {
                boolean flag = false;
                if(inputStr.charAt(i) == inputStr.charAt(j)) {
                    int newI = i;
                    int newJ = j;
                    while(inputStr.charAt(newI) == inputStr.charAt(newJ) ) {
                        newI++;
                        newJ--;
                        if(i == newJ && j == newI) {
                            flag = true;
                            break;
                        }
                    }
                    if(flag) {
                        String newString = inputStr.substring(i, newI+1);
                        if(newString.length() > result.length()) {
                            result = newString;
                        }
                    }

                }
            }
        }
        if(result.length() < 2) {
            throw new InvalidStringException("String does not contain palindromes.");
        }

        Palindrome palindrome = new Palindrome(result);
        palindromeRepo.save(palindrome);
        return new ResponseEntity<>(palindrome, HttpStatus.CREATED);
    }


    @GetMapping("/longest-palindrome/getAllSavedPalindromes")
    public List<Palindrome> getAllSavedPalindromes() {
        return palindromeRepo.findAll();
    }


}
