/*
package Alg1;

import java.util.Arrays;
import java.util.Stack;

public class JavaK {

    // Product and Category Models
    class Product {
        int id;
        String name;
        int price;
        Category category;

        public Product(int id, String name, int price, Category category) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.category = category;
        }

        @Override
        public String toString() {
            return "Product{id=" + id + ", name='" + name + "', price=" + price + ", category=" + category.name + "}";
        }
    }

    class Category {
        int id;
        String name;

        public Category(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    static class QuickSort {
        public static void quickSort(Product[] products, int low, int high) {
            if (low < high) {
                int pi = partition(products, low, high);
                quickSort(products, low, pi - 1);
                quickSort(products, pi + 1, high);
            }
        }
        private static int partition(Product[] products, int low, int high) {
            int pivot = products[high].price;
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (products[j].price <= pivot) {
                    i++;
                    swap(products, i, j);
                }       //Kaiypov Yerassyl
            }
            swap(products, i + 1, high);
            return i + 1;
        }
        private static void swap(Product[] products, int i, int j) {
            Product temp = products[i];
            products[i] = products[j];
            products[j] = temp;
        }
    }
    static class InversionCount {
        public static int Scount(Product[] products) {
            return SCount(products, 0, products.length - 1);
        }
        private static int SCount(Product[] products, int left, int right) {
            int count = 0;
            if (left < right) {
                int mid = (left + right) / 2;
                count += SCount(products, left, mid);
                count += SCount(products, mid + 1, right);
                count += mergeAndCount(products, left, mid, right);
            }
            return count;
        }
        private static int mergeAndCount(Product[] products, int left, int mid, int right) {
            Product[] leftArray = Arrays.copyOfRange(products, left, mid + 1);
            Product[] rightArray = Arrays.copyOfRange(products, mid + 1, right + 1);
            int i = 0, j = 0, k = left, swaps = 0;

            while (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i].price <= rightArray[j].price) {
                    products[k++] = leftArray[i++];
                } else {
                    products[k++] = rightArray[j++]; //Kaiypov Yerassyl
                    swaps += (mid + 1) - (left + i);
                }
            }
            while (i < leftArray.length) products[k++] = leftArray[i++];
            while (j < rightArray.length) products[k++] = rightArray[j++];
            return swaps;
        }
    }
    static class BinarySearch {
        public static int binarySearch(Product[] products, String name) {
            int left = 0, right = products.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int comparison = products[mid].name.compareTo(name);

                if (comparison == 0)
                    return mid;
                if (comparison < 0) //Kaiypov Yerassyl
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            return -1;
        }
    }

    // Recursive Combination Generation
    static class Combinations {
        public static void generateCombinations(Product[] products, int k) {
            Product[] combination = new Product[k];
            generateCombinationsRecursive(products, combination, 0, 0, k);
        }
        private static void generateCombinationsRecursive(Product[] products, Product[] combination, int start, int index, int k) {
            if (index == k) {
                System.out.println(Arrays.toString(combination));
                return;
            }
            for (int i = start; i < products.length; i++) {
                combination[index] = products[i];
                generateCombinationsRecursive(products, combination, i + 1, index + 1, k);
            }   //Kaiypov Yerassyl
        }
    }

    // Stack for Cart Operations
    static class ProductStack {
        Stack<Product> stack = new Stack<>();
        public void push(Product product) {
            stack.push(product);
        }
        public Product pop() {
            if (stack.isEmpty()) {
                System.out.println("Stack is empty, unable to pop.");
                return null;
            }
            return stack.pop(); //Kaiypov Yerassyl
        }
        public Product peek() {
            if (stack.isEmpty()) {
                System.out.println("Stack is empty, unable to peek.");
                return null;
            }
            return stack.peek();
        }
    }

    // Queue for Order Management
    static class OrderQueue {
        java.util.Queue<Product> queue = new java.util.LinkedList<>();
        public void enqueue(Product product) {
            queue.add(product);
        }
        public Product dequeue() { //Kaiypov Yerassyl
            if (queue.isEmpty()) {
                System.out.println("Queue is empty, unable to dequeue.");
                return null;
            }
            return queue.poll();
        }
    }

    // Linked List for Product Management
    static class Node {
        Product product;
        Node next;
        public Node(Product product) {
            this.product = product;
            this.next = null;
        }
    }
    static class LinkedList { //Kaiypov Yerassyl
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
        public Product search(int id) { //Kaiypov Yerassyl
            Node temp = head;
            while (temp != null) {
                if (temp.product.id == id) {
                    return temp.product;
                }
                temp = temp.next;
            }
            return null;
        }
    }

    // Main Class to Test All Components
    public static class OnlineStore {
        public static void main(String[] args) {
            // Sample products
            Product[] products = {
                    new Product(1, "Product A", 300, new Category(1, "Electronics")),
                    new Product(2, "Product B", 200, new Category(2, "Books")),
                    new Product(3, "Product C", 400, new Category(1, "Electronics"))
            };

            // QuickSort
*/
