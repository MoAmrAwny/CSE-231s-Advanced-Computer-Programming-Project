
public class DrinkItems implements Items,Comparable<DrinkItems> {


    private String name;
    private double price;
    private String size;

    public DrinkItems(String name, double price) {
        this.name = name;
        this.price = price;

    }


    @Override
    public int compareTo(DrinkItems other) {
        // Compare drink items based on their prices
        return Double.compare(this.price, other.price);
    }

    @Override
    public void DisplayDetails() {
        System.out.println("Name: " + name + ", Price: $" + price + ", Size: " + size);
    }
    public String getname() {
        return name;
    }

    @Override
    public double getprice() {
        return price;
    }
}

