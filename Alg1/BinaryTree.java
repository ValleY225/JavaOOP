package Alg1;



class BinaryTree {
    // Node class to represent each node in the BST
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    // Constructor
    public BinaryTree() {
        root = null;
    }

    // Insert a new key
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        // Return the unchanged node pointer
        return root;
    }

    // Delete a key
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        // Base case
        if (root == null) return root;

        // Recur down the tree
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Search for a key
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null) return false;
        if (root.key == key) return true;

        // Key is greater than root's key
        if (key > root.key) return searchRec(root.right, key);

        // Key is smaller than root's key
        return searchRec(root.left, key);
    }

    // In-order traversal
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Pre-order traversal
    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order traversal
    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Main method to test the BST
    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();

        // Insert keys
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Print in-order traversal
        System.out.println("In-order traversal:");
        bst.inorder();

        // Search for a key
        System.out.println("\n\nSearch for 40: " + bst.search(40));
        System.out.println("Search for 90: " + bst.search(90));

        // Delete a key
        System.out.println("\nDelete 20:");
        bst.deleteKey(20);
        bst.inorder();

        System.out.println("\nDelete 30:");
        bst.deleteKey(30);
        bst.inorder();

        System.out.println("\nDelete 50:");
        bst.deleteKey(50);
        bst.inorder();
    }
}