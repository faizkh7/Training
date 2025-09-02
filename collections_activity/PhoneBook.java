import java.util.LinkedList;

public class PhoneBook {
    private LinkedList<Contact> contacts = new LinkedList<>();

    public void addContact(String name, String phoneNumber) {
        contacts.add(new Contact(name, phoneNumber));
    }

    public Contact findContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equals(name)) return c;
        }
        System.out.println("Contact " + name + " not found.");
        return null;
    }

    public void printContacts() {
        System.out.println("PhoneBook Contacts:");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}

// Contact class inside same file
class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }

    @Override
    public String toString() {
        return name + " : " + phoneNumber;
    }
}
