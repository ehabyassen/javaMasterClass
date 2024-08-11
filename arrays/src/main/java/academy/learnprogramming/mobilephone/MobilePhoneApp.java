package academy.learnprogramming.mobilephone;

import java.util.Scanner;

public class MobilePhoneApp {

    public static final MobilePhone MOBILE_PHONE = new MobilePhone();
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int option;
        while (!quit) {
            printOptions();
            option = SC.nextInt();
            switch (option) {
                case 0 -> quit = true;
                case 1 -> addNewContact();
                case 2 -> modifyContact();
                case 3 -> removeContact();
                case 4 -> queryContact();
                case 5 -> printAllContacts();
            }
        }
    }

    private static void printAllContacts() {
        System.out.println("Printing all contacts:");
        MOBILE_PHONE.printAllContacts();
    }

    private static void queryContact() {
        System.out.println("Query contact:");
        System.out.println("Name:");
        String name = SC.next();
        Contact contact = MOBILE_PHONE.findByName(name);
        if (contact != null) {
            System.out.println("Found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void removeContact() {
        System.out.println("Removing contact:");
        System.out.println("Name:");
        String name = SC.next();
        Contact contact = MOBILE_PHONE.findByName(name);
        if (contact != null) {
            MOBILE_PHONE.remove(contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void modifyContact() {
        System.out.println("Modifying contact:");
        System.out.println("Name: ");
        String name = SC.next();
        Contact contact = MOBILE_PHONE.findByName(name);
        if (contact != null) {
            System.out.println("New Name: ");
            String newName = SC.next();
            System.out.println("New Number: ");
            String newPhoneNumber = SC.next();
            Contact newContact = new Contact(newName, newPhoneNumber);
            MOBILE_PHONE.modify(name, newContact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact:");
        System.out.println("Name: ");
        String name = SC.next();
        System.out.println("Phone Number: ");
        String phoneNumber = SC.next();
        Contact contact = new Contact(name, phoneNumber);
        MOBILE_PHONE.store(contact);
    }

    private static void printOptions() {
        System.out.println(
                """
                        Options:
                        \t0 - to quit
                        \t1 - to add a new contact
                        \t2 - to modify a contact
                        \t3 - to remove a contact
                        \t4 - to query contact
                        \t5 - to print all contacts
                        """
        );
    }
}
