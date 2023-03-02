/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Longest.Substring.Without.Repeating.Characters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class AppTest {
private Solution solution;
    @BeforeEach
    public void initEach(){
        solution=new Solution();
    }


    @Test 
    void test1() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void test2() {
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void test3() {
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }
}
