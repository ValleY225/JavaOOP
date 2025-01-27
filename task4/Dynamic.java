package task4;

import java.util.Arrays;
import java.util.PriorityQueue;


class BinaryTree {
    static class Node {
        int data;
        Node left, right;
        Node(int value) {
            data = value;
            left = right = null;
        } //Kayipov Yerasyl
    }
    Node root;
    void insert(int value) {
        root = insertRec(root, value);
    }
    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);
        return root;
    }
    void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }
    void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    } //Kayipov Yerasyl
    int height(Node node) {
        if (node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Pre-order traversal:");
        tree.preOrderTraversal(tree.root);

        System.out.println("\nIn-order traversal:");
        tree.inOrderTraversal(tree.root);

        System.out.println("\nPost-order traversal:");
        tree.postOrderTraversal(tree.root);

        System.out.println("\nHeight of the tree: " + tree.height(tree.root));
    }
}

class BST {
    static class Node {
        int data;
        Node left, right;
        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    Node root;
    void insert(int value) {
        root = insertRec(root, value);}   //Kayipov Yerasyl
    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;}
        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);
        return root;
    }
    boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (key < root.data)
            return search(root.left, key);
        return search(root.right, key);
    }
    Node delete(Node root, int key) {
        if (root == null) return root;
        if (key < root.data) root.left = delete(root.left, key);
        else if (key > root.data) root.right = delete(root.right, key);
        else {if (root.left == null) return root.right;
              else if (root.right == null) return root.left;
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);} return root;}
    int minValue(Node root) {
        int minVal = root.data;
        while (root.left != null) {
            minVal = root.left.data;
            root = root.left;}
        return minVal;
    } //Kayipov Yerasyl
    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        System.out.println("In-order traversal:");
        bst.inOrderTraversal(bst.root);
        System.out.println("\nSearch for 40: " + bst.search(bst.root, 40));
        bst.root = bst.delete(bst.root, 20);
        System.out.println("\nIn-order traversal after deletion:");
        bst.inOrderTraversal(bst.root);
    }
}

class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.add(new Task("Task 1", 3));
        taskQueue.add(new Task("Task 2", 1));
        taskQueue.add(new Task("Task 3", 4));
        taskQueue.add(new Task("Task 4", 2));
        while (!taskQueue.isEmpty()) {
            System.out.println("Deleting task number: " + taskQueue.poll());
        }
    } //Kayipov Yerasyl
}
class Task implements Comparable<Task> {
    private String name;
    private int priority;
    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

class HeapExample {
    private int[] heap;
    private int size;
    private boolean isMinHeap;
    public HeapExample(int capacity, boolean isMinHeap) {
        this.heap = new int[capacity];
        this.size = 0;
        this.isMinHeap = isMinHeap;
    }
    public void insert(int value) {
        if (size >= heap.length) {
            throw new IllegalStateException("Heap is full");}
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }  //Kayipov Yerasyl
    public int extractRoot() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");}
        int root = heap[0];
        heap[0] = heap[--size];
        heapifyDown(0);
        return root;
    }
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && compare(heap[index], heap[parent])) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }}
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int candidate = index;
        if (leftChild < size && compare(heap[leftChild], heap[candidate])) {
            candidate = leftChild;}
        if (rightChild < size && compare(heap[rightChild], heap[candidate])) {
            candidate = rightChild;}
        if (candidate != index) {
            swap(index, candidate);
            heapifyDown(candidate);}}
    private boolean compare(int child, int parent) { return isMinHeap ? child < parent : child > parent;}
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;}    //Kayipov Yerasyl
    public void printHeap() { System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));}
    public static void main(String[] args) {
        System.out.println("Min Heap example:");
        HeapExample minHeap = new HeapExample(10, true);
        minHeap.insert(50);
        minHeap.insert(45);
        minHeap.insert(40);
        minHeap.insert(35);
        minHeap.printHeap();
        System.out.println("Extracted: " + minHeap.extractRoot());
        minHeap.printHeap();
        System.out.println("Max Heap example:");
        HeapExample maxHeap = new HeapExample(10, false);
        maxHeap.insert(84);
        maxHeap.insert(65);
        maxHeap.insert(54);
        maxHeap.insert(92);
        maxHeap.printHeap();
        System.out.println("Extracted: " + maxHeap.extractRoot());
        maxHeap.printHeap();
    }
}

class FibonacciDP {
    public static int fibonacciBottomUp(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }       //Kayipov Yerasyl
    public static int fibonacciMemoization(int n) {
        int[] memo = new int[n + 1];
        return fibonacciMemo(n, memo);
    }
    private static int fibonacciMemo(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        return memo[n];
    }
    public static void main(String[] args) {
        int n = 10;
        long BottomUpTime = System.nanoTime();
        System.out.println("Fibonacci number(Bottom-up) for n = " + n + ": " + fibonacciBottomUp(n));
        long BottomupEndTime = System.nanoTime();
        long BottomUp = BottomupEndTime - BottomUpTime;
        System.out.println("Time in nanosec: " + BottomUp);

        long MemoTime = System.nanoTime();
        System.out.println("Fibonacci number(Memoization) for n = " + n + ": " + fibonacciMemoization(n));
        long MemoEndTime = System.nanoTime();
        long Memoization = MemoEndTime - MemoTime;
        System.out.println("Time in nanosec: " + Memoization);
    }
}

class KnapsackDP {
    public static int knapsackBottomUp(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }}} return dp[n][capacity]; }
    public static int knapsackMemoization(int[] weights, int[] values, int capacity) {
        int[][] memo = new int[weights.length + 1][capacity + 1];
        return knapsackMemoHelper(weights, values, capacity, weights.length, memo);
    }
    private static int knapsackMemoHelper(int[] weights, int[] values, int capacity, int n, int[][] memo) {
        if (n == 0 || capacity == 0) return 0;
        if (memo[n][capacity] != 0) return memo[n][capacity]; //Kayipov Yerasyl
        if (weights[n - 1] <= capacity) {
            memo[n][capacity] = Math.max(
                    values[n - 1] + knapsackMemoHelper(weights, values, capacity - weights[n - 1], n - 1, memo),
                    knapsackMemoHelper(weights, values, capacity, n - 1, memo));
        } else { memo[n][capacity] = knapsackMemoHelper(weights, values, capacity, n - 1, memo);} return memo[n][capacity];
    }
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4}; int[] values = {65, 35, 33, 42}; int capacity = 5;
        long BottomUpTime = System.nanoTime();
        System.out.println("Maximum value (Bottom-up) for capacity " + capacity + ": " + knapsackBottomUp(weights, values, capacity));
        long BottomupEndTime = System.nanoTime();
        long BottomUp = BottomupEndTime - BottomUpTime;
        System.out.println("Time in nanosec: " + BottomUp);
        long MemoTime = System.nanoTime();
        System.out.println("Maximum value (Memoization) for capacity " + capacity + ": " + knapsackMemoization(weights, values, capacity));
        long MemoEndTime = System.nanoTime();
        long Memoization = MemoEndTime - MemoTime;
        System.out.println("Time in nanosec: " + Memoization);
    }
}
