package task3;



import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        System.out.println("\n Array Manipulation");
        System.out.println("\n ");
        int[] arr = new int[10];
        Random ran = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(100) + 1;
        }

        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }//Kayipov Yerasyl

        System.out.println("Max: " + max + ", Min: " + min);
        System.out.println("Array: " + Arrays.toString(arr));

        long ArrayTime = System.nanoTime();//To calculate the time of array

        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        long ArrayEndTime = System.nanoTime();
        long ArrayDuration = ArrayEndTime - ArrayTime;
        System.out.println("Execution time of Array.sort: " + (ArrayDuration / 1000000) + " ms");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to search: ");
        int target = scanner.nextInt();

        int index = Arrays.binarySearch(arr, target);
        if (index >= 0) {
            System.out.println("Number found at index: " + index);
        }
        else {
            System.out.println("Number not found.");}



        long StackTime = System.nanoTime();
        System.out.println("\n Stack Implementation");
        Stack stack = new Stack(7);
        stack.push(85);
        stack.push(25);
        stack.push(42);
        stack.push(65);
        stack.push(74);
        stack.push(31);
        stack.push(42);
        stack.push(34);
        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();//Kayipov Yerasyl
        stack.pop();
        stack.peek();
        long StackEndTime = System.nanoTime();
        long StackDuration = StackEndTime - StackTime;
        System.out.println("Execution time of Stack: " + (StackDuration / 1000000) + " ms");

        long LLTime = System.nanoTime();
        System.out.println("\n Singly Linked List");
        Linklist linkedList = new Linklist();
        linkedList.insertAtBeginning(10);
        linkedList.insertAtEnd(40);
        linkedList.insertAtEnd(30);
        linkedList.insertAtEnd(50);
        linkedList.insertAtEnd(19);
        linkedList.insertAtEnd(57);
        linkedList.insertAtEnd(53);
        linkedList.insertAtEnd(52);
        linkedList.insertAtEnd(16);
        linkedList.insertAtEnd(42);
        linkedList.display();
        linkedList.deleteNode(40);
        linkedList.deleteNode(30);
        linkedList.deleteNode(52);//Kayipov Yerasyl
        linkedList.deleteNode(57);
        linkedList.deleteNode(42);
        linkedList.display();
        linkedList.reverse();
        linkedList.display();
        long LLEndTime = System.nanoTime();
        long LLDuration = LLEndTime - LLTime;
        System.out.println("Execution time of Linked List: " + (LLDuration / 1000000) + " ms");

        long DTime = System.nanoTime();
        System.out.println("\n Deque Implementation");
        Deque deque = new Deque();
        deque.insertFront(10);
        deque.insertBack(20);
        deque.insertFront(5);
        deque.insertBack(205);
        deque.insertFront(35);
        deque.insertBack(25);
        deque.insertFront(15);
        deque.removeBack();
        deque.removeFront();
        deque.removeBack();
        deque.removeBack();
        long DEndTime = System.nanoTime();
        long DDuration = DEndTime - DTime;
        System.out.println("Execution time of Deque: " + (DDuration / 1000000) + " ms");

        long QueueTime = System.nanoTime();
        System.out.println("\n Queue Implementation");
        Queue queue = new Queue();
        queue.enqueue(16);
        queue.enqueue(17);
        queue.enqueue(18);
        queue.displayQueue();
        queue.dequeue();
        queue.displayQueue();
        queue.enqueue(20);
        queue.displayQueue();
        queue.dequeue();
        queue.dequeue();
        queue.displayQueue();
        long QueueEndTime = System.nanoTime();
        long QueueDuration = QueueEndTime - QueueTime;
        System.out.println("Execution time of Deque: " + (QueueDuration / 1000000) + " ms");

        System.out.println("\n HashMap Usage");
        long HashTime = System.nanoTime();
        Hash_Map student = new Hash_Map();
        student.addStudent("Adam1", 85);
        student.addStudent("Adam2", 92);
        student.addStudent("Adam3", 67);
        student.addStudent("Adam4", 74);
        student.printAllStudents();
        student.searchGrade("Adam1");
        student.removeStudent("Adam3");
        student.printAllStudents();
        long HashEndTime = System.nanoTime();
        long HashDuration = HashEndTime - HashTime;
        System.out.println("Execution time of Hash Map: " + (HashDuration / 1000000) + " ms");

        System.out.println("\n Tree Set Implementation");
        Tree_Set tse = new Tree_Set();
        tse.addElement(13);
        tse.addElement(16);
        tse.addElement(33);
        tse.addElement(41);
        tse.addElement(12);
        tse.addElement(65);
        tse.addElement(64);
        tse.addElement(75);
        tse.addElement(85);
        tse.addElement(13); // Duplicated element
        tse.display();
        tse.removeElement(13);
        tse.removeElement(65);
        tse.removeElement(33);
        tse.display();
        long TreeTime = System.nanoTime();
        tse.searchElement(16);
        long TreeEndTime = System.nanoTime();
        long TreeDuration = TreeEndTime - TreeTime;
        System.out.println("Execution time of Tree Set: " + (TreeDuration / 1000000) + " ms");

        System.out.println("\n HashTable Implementation");
        long TableTime = System.nanoTime();
        Phonebook pb = new Phonebook();
        pb.addContact("Adam1", "435-45-54");
        pb.addContact("Adam2", "324-43-89");
        pb.addContact("Adam3", "764-24-42");
        pb.addContact("Adam4", "743-13-67");
        pb.addContact("Adam5", "856-24-34");
        pb.addContact("Adam6", "875-43-53");
        pb.addContact("Adam7", "325-42-53");
        pb.addContact("Adam8", "135-43-35");
        pb.addContact("Adam9", "115-44-23");
        pb.displayContact();
        pb.searchContact("Adam5");
        pb.removeContact("Adam3");
        pb.removeContact("Adam1");
        pb.removeContact("Adam5");
        pb.displayContact();
        long TableEndTime = System.nanoTime();
        long TableDuration = TableEndTime - TableTime;
        System.out.println("Execution time of Hash Table: " + (TableDuration / 1000000) + " ms");

    }
}

