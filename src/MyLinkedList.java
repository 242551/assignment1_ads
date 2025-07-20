import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>, Iterable<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size = 0;

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);

        if (index == size) {
            add(item);
            return;
        }

        MyNode newNode = new MyNode(item);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            MyNode current = getNode(index);
            MyNode previous = current.prev;

            previous.next = newNode;
            newNode.prev = previous;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        MyNode removed;

        if (index == 0) {
            removed = head;
            head = head.next;
            if (head != null) head.prev = null;
            if (size == 1) tail = null;
        } else if (index == size - 1) {
            removed = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            removed = getNode(index);
            MyNode before = removed.prev;
            MyNode after = removed.next;
            before.next = after;
            after.prev = before;
        }

        size--;
        return removed.data;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    private MyNode getNode(int index) {
        checkIndex(index);
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++)
                current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--)
                current = current.prev;
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index: " + index);
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Invalid index for add: " + index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<T> {
        private MyNode current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T val = current.data;
            current = current.next;
            return val;
        }
    }
}
