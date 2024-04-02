public class OffByN implements CharacterComparator {
    int diff = 0;

    public OffByN(int n) {
        diff = n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == diff;
    }
}
