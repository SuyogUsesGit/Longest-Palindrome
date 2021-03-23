package com.app.longestpalindrome.repository;

import com.app.longestpalindrome.bean.Palindrome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeRepo extends JpaRepository<Palindrome, Integer> {

}
