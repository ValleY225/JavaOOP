package task3;

import java.util.LinkedList;

class Deque {
    private LinkedList<Integer> deque = new LinkedList<>();

    public void insertFront(int value) {
        deque.addFirst(value);
        display();
    }

    public void insertBack(int value) {
        deque.addLast(value);
        display();
    }

    public void removeFront() {
        if (!deque.isEmpty()) {
            deque.removeFirst();
        } else {
            System.out.println("Deque is empty");
        }
        display();
    }
    //Kayipov Yerasyl
    public void removeBack() {
        if (!deque.isEmpty()) {
            deque.removeLast();
        } else {
            System.out.println("Deque is empty");
        }
        display();
    }
    public void display() {
        System.out.println("Deque: " + deque);
    }
}
