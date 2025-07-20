public interface MyList<T> extends Iterable<T> {
    void add(T item);
    void add(int index, T item);
    T get(int index);
    void set(int index, T item);
    T remove(int index);
    int size();
}

