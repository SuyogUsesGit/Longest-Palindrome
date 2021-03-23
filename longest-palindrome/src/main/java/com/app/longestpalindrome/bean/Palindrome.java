package com.app.longestpalindrome.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Palindrome {

    @Id
    @GeneratedValue
    private int id;
    private String palindromeString;

    public Palindrome() {

    }

    public Palindrome(String palindromeString) {
        this.palindromeString = palindromeString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalindromeString() {
        return palindromeString;
    }

    public void setPalindromeString(String palindromeString) {
        this.palindromeString = palindromeString;
    }

}
