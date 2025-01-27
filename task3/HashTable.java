package task3;

import java.util.Hashtable;
import java.util.Map;

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
            System.out.println("HashTable -> Search is -1.");
        }//Kayipov Yerasyl
    }

    public void displayContact() {
        System.out.println("Phonebook:");
        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
