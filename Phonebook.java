import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
    }
}

public class PhoneBook {

    private static Map<String, Contact> phonebook = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        if (phonebook.containsKey(name)) {
            System.out.println("Contact already exists with this name.");
            return;
        }

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        Contact newContact = new Contact(name, phoneNumber, email);
        phonebook.put(name, newContact);
        System.out.println("Contact added successfully.");
    }

    public static void viewContacts() {
        if (phonebook.isEmpty()) {
            System.out.println("Phonebook is empty.");
            return;
        }

        System.out.println("\n--- All Contacts ---");
        for (Contact contact : phonebook.values()) {
            System.out.println(contact);
            System.out.println("---------------------");
        }
    }

    public static void searchContact() {
        System.out.print("Enter Name to search: ");
        String name = scanner.nextLine().trim();

        if (phonebook.containsKey(name)) {
            System.out.println("Contact found:");
            System.out.println(phonebook.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void updateContact() {
        System.out.print("Enter Name of contact to update: ");
        String name = scanner.nextLine().trim();

        if (phonebook.containsKey(name)) {
            Contact contact = phonebook.get(name);
            System.out.println("Enter new details (leave blank to keep current):");

            System.out.print("New Phone Number (current: " + contact.getPhoneNumber() + "): ");
            String newPhone = scanner.nextLine().trim();
            if (!newPhone.isEmpty()) {
                contact.setPhoneNumber(newPhone);
            }

            System.out.print("New Email (current: " + contact.getEmail() + "): ");
            String newEmail = scanner.nextLine().trim();
            if (!newEmail.isEmpty()) {
                contact.setEmail(newEmail);
            }

            System.out.println("Contact updated.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void deleteContact() {
        System.out.print("Enter Name of contact to delete: ");
        String name = scanner.nextLine().trim();

        if (phonebook.containsKey(name)) {
            phonebook.remove(name);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void menu() {
        while (true) {
            System.out.println("\n--- Phonebook Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    viewContacts();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    updateContact();
                    break;
                case "5":
                    deleteContact();
                    break;
                case "6":
                    System.out.println("Exiting phonebook. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
