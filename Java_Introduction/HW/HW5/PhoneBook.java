import java.util.*;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void addContact(String name, String number){
        ArrayList<String> numbers = phoneBook.get(name);
        if (numbers == null){
            numbers = new ArrayList<>();
            numbers.add(number);
            phoneBook.put(name, numbers);
        } else {
            if(!numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }

    public List<Map.Entry<String, ArrayList<String>>> getContacts(){
        List<Map.Entry<String, ArrayList<String>>> list = new ArrayList<>(phoneBook.entrySet());
        Comparator<Map.Entry<String, ArrayList<String>>> comparator = (entry1, entry2) ->
                Integer.compare(entry2.getValue().size(), entry1.getValue().size());
        Collections.sort(list, comparator);
        return list;
    }
}
