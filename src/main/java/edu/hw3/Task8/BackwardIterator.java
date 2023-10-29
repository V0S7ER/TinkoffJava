package edu.hw3.Task8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class BackwardIterator<T> implements Iterator<T> {

    private final List<T> elements;

    public BackwardIterator(List<T> elements) {
        if (elements == null) {
            this.elements = new ArrayList<>();
        } else {
            this.elements = new ArrayList<>(elements);
        }
    }

    @Override
    public boolean hasNext() {
        return !elements.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }

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
