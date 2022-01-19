import java.util.*;

public class DoublyLinkedList<E> {

    private List<E> elements = new ArrayList<E>();

    public void push(E element) {
        elements.add(element);
    }

    public E pop() {
        return elements.remove(elements.size() - 1);
    }

    public E shift() {
        return elements.remove(0);
    }

    public E unshift(E element) {
        elements.add(0, element);
        return element;
    }

}
