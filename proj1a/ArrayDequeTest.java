public class ArrayDequeTest {

    public static boolean checkEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            System.out.println("Error: expected " + expected + ", but got: " + actual);
            return false;
        }
        return true;
    }

    public static void testAddAndGet() {
        System.out.println("Running AD-basic: Test add and get.");
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addLast(0);
        ad.addLast(1);
        ad.addLast(2);

        boolean passed = checkEquals(0, ad.get(0)) &&
                checkEquals(1, ad.get(1)) &&
                checkEquals(2, ad.get(2));

        printTestStatus(passed);
    }

    public static void testRemoveFromEmpty() {
        System.out.println("Running AD-basic: Removing from empty deque.");
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        boolean passed = ad.removeFirst() == null && ad.removeLast() == null;
        printTestStatus(passed);
    }

    public static void testFillEmptyFill() {
        System.out.println("Running AD-basic: Fill up, empty, fill up again.");
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            ad.addLast(i);
        }
        System.out.println("Fill Completed");
        for (int i = 0; i < 10; i++) {
            ad.removeFirst();
        }
        System.out.println("Remove Completed");
        for (int i = 0; i < 10; i++) {
            ad.addLast(i);
        }
        System.out.println("Refill Completed");
        boolean passed = checkEquals(10, ad.size());
        printTestStatus(passed);
    }

    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting ArrayDeque tests.");

        // Test adding and getting items
        testAddAndGet();

        // Test removing items from an empty deque
        testRemoveFromEmpty();

        // Test filling up the deque, emptying it, and then filling it again
        testFillEmptyFill();

        // Additional tests
        testAddFirstAndRemoveLast();
        testAddLastAndRemoveFirst();
        testSizeAfterMultipleOperations();
        testMultipleAddAndRemoveOperations();
    }

    public static void testAddFirstAndRemoveLast() {
        System.out.println("Running AD-basic: Random addFirst/removeLast/isEmpty tests.");
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(1);
        ad.addFirst(2);
        boolean passed = checkEquals(1, ad.removeLast());
        passed = checkEquals(false, ad.isEmpty()) && passed;
        printTestStatus(passed);
    }

    public static void testAddLastAndRemoveFirst() {
        System.out.println("Running AD-basic: Random addLast/removeFirst/isEmpty tests.");
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addLast(3);
        ad.addLast(4);
        boolean passed = checkEquals(3, ad.removeFirst());
        passed = checkEquals(false, ad.isEmpty()) && passed;
        printTestStatus(passed);
    }

    public static void testSizeAfterMultipleOperations() {
        System.out.println("Running AD-basic: Random add/remove/isEmpty/size tests.");
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.addFirst("a");
        ad.addLast("b");
        ad.removeFirst();
        ad.addLast("c");
        ad.addFirst("d");
        boolean passed = checkEquals(3, ad.size());
        passed = checkEquals(false, ad.isEmpty()) && passed;
        printTestStatus(passed);
    }

    public static void testMultipleAddAndRemoveOperations() {
        System.out.println("Running AD-basic: Fill up, empty, fill up again with different operations.");
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            ad.addFirst(i);
        }
        for (int i = 0; i < 5; i++) {
            ad.removeLast();
        }
        for (int i = 0; i < 5; i++) {
            ad.addLast(i);
        }
        boolean passed = checkEquals(5, ad.size());
        printTestStatus(passed);
    }
}
