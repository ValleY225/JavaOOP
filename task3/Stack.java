package task3;
class Stack {
    private int[] stack;
    private int top;
    private int maxSize;
    public Stack(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow");
            return;
        }//Kayipov Yerasyl
        stack[++top] = value;
        display();
    }
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println("Popped: " + stack[top--]);
        display();
    }
    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Peek: " + stack[top]);
    }
    public void display() {
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

