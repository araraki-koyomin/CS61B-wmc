import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        boolean expected0 = palindrome.isPalindrome("");
        assertTrue(expected0);

        boolean expected1 = palindrome.isPalindrome("a");
        assertTrue(expected1);

        boolean expected2 = palindrome.isPalindrome("racecar");
        assertTrue(expected2);

        boolean expected3 = palindrome.isPalindrome("noon");
        assertTrue(expected3);

        boolean expected4 = palindrome.isPalindrome("car");
        assertFalse(expected4);

        boolean expected5 = palindrome.isPalindrome("food");
        assertFalse(expected5);

        boolean expected6 = palindrome.isPalindrome("Aa");
        assertFalse(expected6);


        OffByOne offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("ab", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("w", offByOne));
        assertFalse(palindrome.isPalindrome("noon", offByOne));
    }
}
