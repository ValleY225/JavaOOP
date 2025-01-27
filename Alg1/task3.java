package Alg1;

/*
import java.util.*;

// Exercise 1: Array Manipulation
class ArrayManipulation {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();

        // Populate the array with random numbers between 1 and 100
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100) + 1;
        }

        // Find the maximum and minimum numbers
        int max = Arrays.stream(numbers).max().orElseThrow();
        int min = Arrays.stream(numbers).min().orElseThrow();

        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Max: " + max + ", Min: " + min);

        // Sort the array
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        // Search for a number using binary search
        System.out.print("Enter number to search: ");
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        int index = Arrays.binarySearch(numbers, target);
        if (index >= 0) {
            System.out.println("Number found at index: " + index);
        } else {
            System.out.println("Number not found.");
        }
    }
}

// Exercise 2: Stack Implementation
class Stack1 {
    private int[] stack;
    private int top;
    private int maxSize;

    public Stack1(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow");
            return;
        }
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

// Exercise 3: Singly Linked List
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class SinglyLinkedList {
    private Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteNode(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
}

// Exercise 4: Deque Implementation
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

// Exercise 5: Queue Using Two Stacks
class QueueWithStacks {
    private Stack1<Integer> stack1 = new Stack<>();
    private Stack1<Integer> stack2 = new Stack<>();

    public void enqueue(int value) {
        stack1.push(value);
    }

    public void dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            System.out.println("Dequeued: " + stack2.pop());
        } else {
            System.out.println("Queue is empty");
        }
    }
}

// Exercise 6: HashMap Usage
class StudentGrades {
    private Map<String, String> grades = new HashMap<>();

    public void addStudent(String name, String grade) {
        grades.put(name, grade);
    }

    public void removeStudent(String name) {
        grades.remove(name);
    }

    public void printAllStudents() {
        for (Map.Entry<String, String> entry : grades.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Grade: " + entry.getValue());
        }
    }

    public void searchGrade(String name) {
        if (grades.containsKey(name)) {
            System.out.println("Grade for " + name + ": " + grades.get(name));
        } else {
            System.out.println("Student not found.");
        }
    }
}

// Exercise 7: TreeSet Implementation
class TreeSetExample {
    private TreeSet<Integer> set = new TreeSet<>();

    public void addElement(int number) {
        set.add(number);
    }

    public void removeElement(int number) {
        set.remove(number);
    }

    public void searchElement(int number) {
        if (set.contains(number)) {
            System.out.println("Found: " + number);
        } else {
            System.out.println("Not found: " + number);
        }
    }

    public void display() {
        System.out.println("TreeSet: " + set);
    }
}

// Exercise 8: Hashtable Implementation
class Phonebook {
    private Hashtable<String, String> phonebook = new Hashtable<>();

    public void addContact(String name, String number) {
        phonebook.put(name, number);
    }

    public void removeContact(String name) {
        phonebook.remove(name);
    }

    public void searchContact(String name) {
        if (phonebook.containsKey(name)) {
            System.out.println(name + "'s number: " + phonebook.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void displayContacts() {
        System.out.println("Phonebook:");
        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
*/
