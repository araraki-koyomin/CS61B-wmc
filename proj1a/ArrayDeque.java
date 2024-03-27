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
        while (ptr != rear) {
            newItems[ptr] = items[ptr];
            ptr = backChange(ptr);
        }
        length *= 2;
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