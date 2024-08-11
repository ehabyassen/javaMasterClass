package academy.learnprogramming.mobilephone;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class MobilePhone {

    private static List<Contact> contacts = new ArrayList<>();

    public void store(Contact contact) {
        if (contacts.stream().noneMatch(c -> c.getName().equals(contact.getName()))) {
            contacts.add(contact);
            System.out.println("Added contact: " + contact);
        } else {
            System.out.println("Contact already exists.");
        }
    }

    public Contact findByName(String name) {
        return contacts.stream().filter(contact -> contact.getName().equals(name)).findFirst().orElse(null);
    }

    public void modify(String name, Contact contact) {
        contacts.set(contacts.indexOf(findByName(name)), contact);
        System.out.println("Modified contact with name: " + name + " to: " + contact);
    }

    public void remove(Contact contact) {
        System.out.println("Removing contact: " + contact);
        contacts.remove(contact);
    }

    public void printAllContacts() {
        System.out.println(contacts.stream().map(Contact::toString).collect(joining("\n", "[", "]")));
    }
}
