package task3;

import java.util.TreeSet;

public class Tree_Set {
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
        }//Kayipov Yerasyl
    }

    public void display() {
        System.out.println("TreeSet: " + set);
    }
}

