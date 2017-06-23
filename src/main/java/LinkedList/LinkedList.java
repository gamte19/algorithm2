package LinkedList;

public class LinkedList<T> {

    private Node<T> head;
    private static int counter = 0;
    private Node<T> tail;

    public void add(T data) {
        if (head == null) {
            head = new Node<T>(data);
        }

        Node<T> tail = head;

        tail.setNext(new Node<T>(data));
        incrementCounter();

        /*Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node<T>(data));
        incrementCounter();*/
    }

    public T getByIndex(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= 0 && index < size()) {
            Node<T> current = head.getNext();

            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }

        throw new ArrayIndexOutOfBoundsException("Invalid index");
    }

    public void insert(int index, T data) throws ArrayIndexOutOfBoundsException {
        if (head == null) {
            head = new Node<T>(data);
        } else if (index >= 0 && index <= size()) {

            Node temp = new Node(data);
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            temp.setNext(current.getNext());
            current.setNext(temp);
            incrementCounter();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Invalid index");
    }

    public void remove(int index) {
        if (index >= 0 && index < size()) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            decreaseCounter();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Invalid index");

    }

    public String toString() {
        String output = "";

        if (head != null) {
            Node current = head.getNext();
            while (current != null) {
                output += "[" + current.getData().toString() + "]";
                current = current.getNext();
            }

        }
        return output;
    }

    private void incrementCounter() {
        counter++;
    }

    private void decreaseCounter() {
        counter--;
    }

    public int size() {
        return counter;
    }
}
