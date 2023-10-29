package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class BackwardIterator<T> implements Iterator<T> {

    private final List<T> elements;

    BackwardIterator(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return !elements.isEmpty();
    }

    @Override
    public T next() {
        return elements.removeLast();
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        Iterator.super.forEachRemaining(action);
    }
}
