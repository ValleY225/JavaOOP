package task3;

import java.util.Stack;

class Queue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();


    public void enqueue(int value) {
        stack1.push(value);//Adds an element to the end of the queue
        System.out.println("Enqueued: " + value);
    }
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }//Removes an element from the front of the queue
        }
        if (stack2.isEmpty()) { //the queue is empty case
            System.out.println("Queue is empty");
            return -1;
        } else {
            int value = stack2.pop();
            System.out.println("Dequeued: " + value);
            return value;
        }
    } //Kayipov Yerasyl
    public void displayQueue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue contents: ");
        if (!stack2.isEmpty()) {
            for (int i = stack2.size() - 1; i >= 0; i--) {
                System.out.print(stack2.get(i) + " ");
            }
        }
        if (!stack1.isEmpty()) {
            for (int i = 0; i < stack1.size(); i++) {
                System.out.print(stack1.get(i) + " ");
            }
        }
        System.out.println();
    }
}
