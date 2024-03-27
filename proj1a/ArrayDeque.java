public class ArrayDeque<T> {
    /**Array for deque*/
    private T[] items;
    /**Deque's size*/
    private int size;
    /**Deque's length*/
    private int length;
    /**Front pointer*/
    private int front;
    /**Rear pointer*/
    private int rear;

    /**
     * Initialize the ArrayDeque
     */
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        length = 8;
        front = 3;
        rear = 4;
    }

    /**
     * Change the ptr forward
     */
    public int forwardChange(int index) {
        if (index == 0) {
            return length - 1;
        } else {
            return index - 1;
        }
    }

    /**
     * Change the ptr back
     */
    public int backChange(int index) {
        if (index == length - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    /**
     * Expand the length of deque
     */
    public void expand() {
        T[] newItems = (T[]) new Object[length * 2];
        int ptr = backChange(front);
        int newPtr = 0;
        while (ptr != rear) {
            newItems[ptr] = items[ptr];
            ptr = backChange(ptr);
        }
        length *= 2;
        front = length - 1;
        rear = size;
        items = newItems;
    }

    /**
     * Add the item to the front position
     */
    public void addFirst(T item) {
        if (size == length) {
            expand();
        }
        items[front] = item;
        front = forwardChange(front);
        size++;
    }

    /**
     *Add the item to the rear position
     */
    public void addLast(T item) {
        if (size == length) {
            expand();
        }
        items[rear] = item;
        rear = backChange(rear);
        size++;
    }

    /**
     * Check whether the deque is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the size of deque
     */
    public int size() {
        return size;
    }

    /**
     * print the deque from thr front position to the rear position
     */
    public void printDeque() {
        int ptr = backChange(front);
        while (ptr != rear) {
            System.out.print(items[ptr].toString() + " ");
            ptr = backChange(ptr);
        }
        System.out.println();
    }

    /**
     * Reduce the length of deque
     */
    public void reduce() {
        T[] newItems = (T[]) new Object[length / 2];
        int ptr = backChange(front);
        int newPtr = 0;
        while (ptr != rear) {
            newItems[newPtr] = items[ptr];
            ptr = backChange(front);
        }
        items = newItems;
        length /= 2;
        front = length - 1;
        rear = size;
    }

    /**
     * Remove the item at the front position and return it
     */
    public T removeFirst() {
        if (length >= 16 && size / length < 0.25) {
            reduce();
        }
        front = backChange(front);
        size--;
        return items[front];
    }

    /**
     * Remove the item at the rear position and return it
     */
    public T removeLast() {
        if (length >= 16 && size / length < 0.25) {
            reduce();
        }
        rear = forwardChange(rear);
        size--;
        return items[rear];
    }

    /**
     * Get the index-th item in deque
     */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int ptr = backChange(front);
        for (int i = 0; i < index; i++) {
            ptr = backChange(front);
        }
        return items[index];
    }
}
//public class ArrayDeque<T> {
//    private T[] items;
//    private int size;
//    private int length;
//    private int front;
//    private int rear;
//
//    public ArrayDeque() {
//        items = (T[]) new Object[8];
//        size = 0;
//        length = 8;
//        front = 0; // 初始化 front 为 0
//        rear = 0; // 初始化 rear 为 0，第一个元素将置于 0 位置
//    }
//
//    private int increment(int index) {
//        return (index + 1) % length;
//    }
//
//    private int decrement(int index) {
//        return (index - 1 + length) % length;
//    }
//
//    private void resize(int capacity) {
//        T[] newItems = (T[]) new Object[capacity];
//        for (int i = 0, j = front; i < size; i++, j = increment(j)) {
//            newItems[i] = items[j];
//        }
//        items = newItems;
//        front = 0;
//        rear = size;
//        length = capacity;
//    }
//
//    public void addFirst(T item) {
//        if (size == length) {
//            resize(length * 2);
//        }
//        front = decrement(front);
//        items[front] = item;
//        size++;
//    }
//
//    public void addLast(T item) {
//        if (size == length) {
//            resize(length * 2);
//        }
//        items[rear] = item;
//        rear = increment(rear);
//        size++;
//    }
//
//    public T removeFirst() {
//        if (isEmpty()) {
//            return null;
//        }
//        T item = items[front];
//        items[front] = null; // Help with garbage collection
//        front = increment(front);
//        size--;
//
//        if (length >= 16 && size <= length / 4) {
//            resize(length / 2);
//        }
//
//        return item;
//    }
//
//    public T removeLast() {
//        if (isEmpty()) {
//            return null;
//        }
//        rear = decrement(rear);
//        T item = items[rear];
//        items[rear] = null; // Help with garbage collection
//        size--;
//
//        if (length >= 16 && size <= length / 4) {
//            resize(length / 2);
//        }
//
//        return item;
//    }
//
//    public T get(int index) {
//        if (index < 0 || index >= size) {
//            return null;
//        }
//        int actualIndex = (front + index) % length;
//        return items[actualIndex];
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    // Assume printDeque doesn't need changes
//    public void printDeque() {
//        int ptr = front;
//        for (int i = 0; i < size; i++) {
//            System.out.print(items[ptr].toString() + " ");
//            ptr = increment(ptr);
//        }
//        System.out.println();
//    }
//}
