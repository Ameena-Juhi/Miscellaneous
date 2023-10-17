package Generics;

import java.util.AbstractCollection;
import java.util.Iterator;

class Tuple_Collection<A, B> {
    private final A first;
    private final B second;

    public Tuple_Collection(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class Pair<A, B> extends Tuple_Collection<A, B> {
    public Pair(A first, B second) {
        super(first, second);
    }
}

class TupleCollection<E> extends AbstractCollection<E> {
    private final Object[] elements;
    private int size;

    public TupleCollection(int capacity) {
        elements = new Object[capacity];
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                @SuppressWarnings("unchecked")
                E element = (E) elements[currentIndex];
                currentIndex++;
                return element;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        if (size < elements.length) {
            elements[size] = element;
            size++;
            return true;
        }
        return false;
    }
}


