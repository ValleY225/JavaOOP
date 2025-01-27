package Alg1;

class Stack {
    private int maxSize;   // Size of the stack
    private int[] stackArray; // Array to store stack elements
    private int top;       // Points to the top of the stack


    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // Indicates that stack is empty
    }

    // Push operation: Adds an element to the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full.");
        } else {
            stackArray[++top] = value; // Increment top and add the element
        }
    }

    // Pop operation: Removes and returns the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;}
        else {
            return stackArray[top--]; // Return the element and decrement top
        }
    }

    // Peek operation: Returns the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // isEmpty operation: Checks if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // isFull operation: Checks if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Display stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the stack
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Stack of size 5

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display(); // Should display: 10 20 30

        System.out.println("Popped: " + stack.pop()); // Should pop 30
        System.out.println("Top element: " + stack.peek()); // Should show 20
        stack.display(); // Should display: 10 20
    }
}

