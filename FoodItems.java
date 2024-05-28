
class FoodItems implements Items, Comparable<FoodItems> {
    private String name;
    private double price;


    public FoodItems(String name, double price ){
        this.name = name;
        this.price = price;

    }



    @Override
    public int compareTo(FoodItems other) {
        // Compare food items based on their names
        return Double.compare(this.price, other.price);
    }


    @Override
    public void DisplayDetails() {
        System.out.println("Name: " + name + ", Price: $" + price );
    }

    @Override
    public String getname() {
        return name;
    }

    @Override
    public double getprice() {
        return price;
    }




}
