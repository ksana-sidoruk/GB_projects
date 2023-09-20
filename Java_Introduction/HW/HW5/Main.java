public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Smb", "+3752066");
        phoneBook.addContact("Smb", "+37520661");
        phoneBook.addContact("Smo", "+37520662");
        phoneBook.addContact("Bob", "+37533661");
        phoneBook.addContact("Smo", "+37520667");
        phoneBook.addContact("Smb", "+3752566");

        var contacts = phoneBook.getContacts();
        for (var contact:
                contacts) {
            System.out.printf("Имя - %s: %s\n", contact.getKey(), contact.getValue());
        }
    }
}