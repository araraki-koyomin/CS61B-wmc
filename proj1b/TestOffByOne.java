import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertTrue(offByOne.equalChars('%', '&'));
        assertTrue(offByOne.equalChars('D', 'C'));
        assertFalse(offByOne.equalChars('a', 'B'));
        assertFalse(offByOne.equalChars('a', 'd'));
        assertTrue(offByOne.equalChars('\n', '\t'));
        assertFalse(offByOne.equalChars('6', '8'));
    }
}
