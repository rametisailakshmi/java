// Person class to hold details for each person
class Person {
    String name;
    String phoneNumber;
    String email;

    // Constructor to initialize Person object
    public Person(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Method to display Person information
    public void display() {
        System.out.println("Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email);
    }
}

public class BubbleSortExample {

    // Bubble sort method to sort an array of Person objects by name
    public static void bubbleSort(Person[] people) {
        int n = people.length;
        boolean swapped;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Inner loop for comparisons in each pass
            for (int j = 0; j < n - 1 - i; j++) {
                // Compare adjacent Person objects by name lexicographically
                if (people[j].name.compareToIgnoreCase(people[j + 1].name) > 0) {
                    // Swap if out of order
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, array is sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        // Sample array of Person objects
        Person[] people = {
            new Person("samyuktha", "123-456-7890", "alice@example.com"),
            new Person("divya", "982395867", "divya@example.com"),
            new Person("navitha", "5557778899", "charlie@example.com"),
            new Person(" sai lakshmi", "9848663418", "diana@example.com")
        };

        System.out.println("Before Sorting:");
        for (Person p : people) {
            p.display();
        }

        // Sort the array by name using bubble sort
        bubbleSort(people);

        System.out.println("\nAfter Sorting:");
        for (Person p : people) {
            p.display();
        }
    }
}
