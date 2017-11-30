package edu.gcccd.csis;

final class Node<E> {
    private static long counter = 0;   // for testing only
    private E element;
    private Node<E> next;
    private Node<E> previous;

    Node(final E element) {
        this.element = element;
    }

    public static void resetCounter() {
        counter = 0;
    }

    public static long getCounter() {
        return counter;
    }

    E getElement() {
        return element;
    }
    Node<E> getPrevious(){
    	Node.counter--;
    	return previous;
    }

    Node<E> getNext() {
        Node.counter++;
        return next;
    }

    void setNext(final Node<E> next) {
        this.next = next;
    }
    void setPrevious(final Node<E> previous) {
        this.previous = previous;
    }
   
}