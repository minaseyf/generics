package inventory;

import products.Product;

import java.util.ArrayList;

public class Inventory<T extends Product> {
    private ArrayList<T> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public void setItems(ArrayList<T> items) {
        this.items = items;
    }

    public void applyDiscount (String productName, int discount) {
        for (T item : items) {
            if (item.getTitle().equals(productName)) {
                double newPrice = item.getPrice() * (100 - discount) / 100;
                item.setPrice(newPrice);
                System.out.println("Discount just applied to " + productName + ".");
                return;
            }
        }
        System.out.println("This " + productName + " product not found for applying discount!");
    }

    public void addItems(T product) {
        items.add(product);
    }

    public void removeItemById(String id) {
        for (T item : items) {
            if (item.getId().equals(id)) {
                items.remove(item);
                System.out.println("The item with ID " + id + " removed successfully!");
                return;
            }
        }
        System.out.println("This item with ID " + id + " not found!");
    }

    public T findItemsById(String id) {
        for (T item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        System.out.println("This item with ID " + id + " not found!");
        return null;
    }

    public void displayAll() {
        if (items.isEmpty()) {
            System.out.println("The inventory is empty!");
            return;
        }
        for (T item : items) {
            System.out.println(item);
        }
    }
}
