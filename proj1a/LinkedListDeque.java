public class LinkedListDeque<T> {
    private class Node {
        T value;
        Node next;
        Node prev;
        public Node(T v, Node n, Node p) {
            value = v;
            next = n;
            prev = p;
        }
        public Node(Node n, Node p) {
            next = n;
            prev = p;
        }
    }

    private final Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        if (other.size() != 0) {
            Node p = other.sentinel.next;
            while (p.value != null) {
                addLast(p.value);
                p = p.next;
            }
        }
    }

    public void addFirst(T item) {
        Node first = new Node(item, sentinel.next, sentinel);
        sentinel.next.prev = first;
        sentinel.next = first;
        size++;
    }

    public void addLast(T item) {
        Node last = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.value.toString() + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (sentinel.next.value != null) {
            T first_value = sentinel.next.value;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
            return first_value;
        } else {
            return null;
        }
    }

    public T removeLast() {
        if (sentinel.prev.value != null) {
            T last_value = sentinel.prev.value;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size--;
            return last_value;
        } else {
            return null;
        }
    }

    public T get(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        }
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.value;
    }


    public T getRecursiveHelper(int index, Node p) {
        if (index == 0) {
            return p.value;
        } else {
            return getRecursiveHelper(index - 1, p.next);
        }
    }
    public T getRecursive(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }
}
