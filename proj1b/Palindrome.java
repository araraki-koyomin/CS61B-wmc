public class Palindrome {
    /** Invert a word into a LinkedListDeque */
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> deque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public static class ExactEqualComparator implements CharacterComparator {
        @Override
        public boolean equalChars(char x, char y) {
            return x == y; // 返回true当且仅当x和y完全相等
        }
    }


    /** Help solve isPalindrome by recursive */
    private boolean isPalindromeHelper(Deque<Character> wordDeque, CharacterComparator cc) {
        if (wordDeque.size() <= 1) {
            return true;
        }
        return cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast())
                && isPalindromeHelper(wordDeque, cc);
    }

    /** Check whether a word is a palindrome */
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        CharacterComparator intEqual = new ExactEqualComparator();
        return isPalindromeHelper(wordDeque, intEqual);
    }

    /** Check whether a word is a palindrome under the condition of cc */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindromeHelper(wordDeque, cc);
    }
}
