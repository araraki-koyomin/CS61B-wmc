public class ArrayDeque<T> {

    T[] items;
    int size;
    int length;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        length = 8;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T []) new Object[other.length];
        size = other.size;
        length = other.length;
        for (int i = 0; i < size; i++) {
            items[i] = (T) other.items[i];
        }
    }

    public void check() {
        while (size < length  * 0.25 && length > 8) {
            int new_len = (int)(length / 2);
            T[] temp_items = (T []) new Object[new_len];
            System.arraycopy(items, 0, temp_items, 0, size);
            items = temp_items;
        }
    }

    public void resise() {
        T[] temp_items = (T []) new Object[length * 2];
        System.arraycopy(items, 0, temp_items, 0, size);
        items = temp_items;
    }
    public void addFirst(T item) {
        if (size == length) {
            resise();
        }
        for (int i = size; i >= 1; i--) {
            items[i] = items[i - 1];
        }
        items[0] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == length) {
            resise();
        }
        items[size] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void PrintDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i].toString() + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        for (int i = 0; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        T x = items[size - 1];
        items[size - 1] = null;
        check();
        return x;
    }

    public T removeLast() {
        T x = items[size - 1];
        items[size - 1] = null;
        check();
        return x;
    }

    public T get(int index) {
        return items[index];
    }
}
