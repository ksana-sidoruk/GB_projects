public class Main {
    public static void main(String[] args) {
        NoteBook asus = new NoteBook("Asus VivaBook", 2, 512, OS.Windows, "металлик");
        NoteBook acer = new NoteBook("Acer EEE", 8, 1024, OS.Windows, "черный");
        NoteBook mac = new NoteBook("MacBook", 8, 1024, OS.iOS, "розовое золото");

        TechShop storage = new TechShop();
        storage.addNotebook(asus);
        storage.addNotebook(acer);
        storage.addNotebook(mac);

        // System.out.println(storage.getNotebooks());

        System.out.println(storage.getFilteredNotebooks(storage.getCriteria()));

    }
}