package problem1;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DequeIterator<AnyType> implements Iterable<AnyType>{
    @Override
    public Iterator<AnyType> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super AnyType> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<AnyType> spliterator() {
        return Iterable.super.spliterator();
    }
}
