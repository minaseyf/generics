import inventory.Inventory;
import products.Accessory;
import products.Book;
import products.Notebook;
import products.Product;

public class Main {
    public static double calculateTotalPrice (Inventory<? extends Product> inventory) {
        double total = 0.0;
        for(Product product : inventory.getItems()) {
            total += product.getPrice();
        }
        return total;
    }
    public static void main(String[] args) {
        Inventory<Book> books = new Inventory<>();
        Inventory<Notebook> notebooks = new Inventory<>();
        Inventory<Accessory> accessories = new Inventory<>();

        Book book1 = new Book("shahname", 155.0, "ferdosi", "bla", "poetry");
        Book book2 = new Book("topoli", 100.99, "ali", "bla", "koodak");
        books.addItems(book1);
        books.addItems(book2);

        Notebook notebook1 = new Notebook("notebook1", 40.50, 20, true);
        Notebook notebook2 = new Notebook("notebook2", 90.0, 100, false);
        notebooks.addItems(notebook1);
        notebooks.addItems(notebook2);

        Accessory accessory1 = new Accessory("Pen", 12.50, "red");
        Accessory accessory2 = new Accessory("Pencil", 4.40, "black");
        accessories.addItems(accessory1);
        accessories.addItems(accessory2);

        System.out.println("books>> ");
        books.displayAll();
        System.out.println("notebooks>> ");
        notebooks.displayAll();
        System.out.println("accessories>> ");
        accessories.displayAll();
        System.out.println();

        books.removeItemById(String.valueOf(Integer.valueOf((books.getItems().getFirst().getId()))));
        accessories.removeItemById(String.valueOf(Integer.valueOf((accessories.getItems().getFirst().getId()))));
        System.out.println();

        System.out.println("books>> ");
        books.displayAll();
        System.out.println("notebooks>> ");
        notebooks.displayAll();;
        System.out.println("accessories>> ");
        accessories.displayAll();
        System.out.println();

        System.out.println("all books price : " + calculateTotalPrice(books));
        System.out.println("all notebooks price : " + calculateTotalPrice(notebooks));
        System.out.println("all accessories price : " + calculateTotalPrice(accessories));
        System.out.println();

        System.out.println(books.findItemsById(book1.getId()));
        System.out.println(books.findItemsById(book2.getId()));
        System.out.println();

        books.applyDiscount(accessories.getItems().getFirst().getTitle() , 15);
        notebooks.applyDiscount(notebooks.getItems().getFirst().getTitle() , 50);
        System.out.println();

        System.out.println("books>> ");
        books.displayAll();
        System.out.println("notebooks>> ");
        notebooks.displayAll();;
        System.out.println("accessories>> ");
        accessories.displayAll();
    }
}