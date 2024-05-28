public class DessertItems implements Items,Comparable<DessertItems> {

    private String name;
    private double price;
    private String type;

    public DessertItems(String name, double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public void DisplayDetails() {
        System.out.println("Name: " + name + ", Price: $" + price + ", Type: " + type);
    }

    @Override
    public int compareTo(DessertItems o) {
        return Double.compare(this.price, o.price);
    }
    public String getname() {
        return name;
    }

    @Override
    public double getprice() {
        return price;
    }
}
