/*
package Midterm;

import java.util.Queue;
import java.util.Stack;

public class DataStructure {
    class ProductStack {
        Stack<Product> stack = new Stack<>();

        public void push(Product product) {
            stack.push(product);
        }

        public Product pop() {
            return stack.pop();
        }

        public Product peek() {
            return stack.peek();
        }
    }

    // Queue for Order Management
    class OrderQueue {
        Queue<Product> queue = new LinkedList<>();

        public void enqueue(Product product) {
            queue.add(product);
        }

        public Product dequeue() {
            return queue.poll();
        }
    }

    // Linked List for Product Storage
    class Node {
        Product product;
        Node next;

        public Node(Product product) {
            this.product = product;
            this.next = null;
        }
    }

    class LinkedList {
        Node head;

        public void add(Product product) {
            Node newNode = new Node(product);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        public void remove(int id) {
            if (head == null) return;

            if (head.product.id == id) {
                head = head.next;
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.product.id != id) {
                temp = temp.next;
            }

            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }

        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.product.name + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}
*/
