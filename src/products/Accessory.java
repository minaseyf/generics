package products;

public class Accessory extends Product{
    private String color;
    private static int counter = 0;


    public Accessory(String title, Double price, String color) {
        super(title, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", Color: " + color;
    }

    @Override
    protected String generateId() {
        counter++;
        return "3" + String.format("%03d", counter);
    }
}
