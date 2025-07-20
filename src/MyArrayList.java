import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private Object[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public MyArrayList() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");

        ensureCapacity();

        // shift elements to the right
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = item;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");

        return (T) data[index];
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");

        T removed = (T) data[index];

        // shift elements to the left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

        return removed;
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < size;
        }

        public T next() {
            return (T) data[currentIndex++];
        }
    }
}
