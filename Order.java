
class Order {
    private List<Items> items;
    private List<Integer> quantities;

    public Order() {
        items = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public void addItem(Items item, int quantity) {
        items.add(item);
        quantities.add(quantity);
    }

    public void removeItem(Items item, int quantity) {
        int index = items.indexOf(item);
        if (index != -1) {
            int currentQuantity = quantities.get(index);
            if (currentQuantity <= quantity) {
                items.remove(index);
                quantities.remove(index);
            } else {
                quantities.set(index, currentQuantity - quantity);
            }
        }
    }
    public void removeItemFromOrder() {

        String y =items.getLast().getname();
        System.out.print(y);
        this.items.remove(items.getLast());
        this.quantities.remove(quantities.getLast());
    }
    public void getLastItem(){
        int x;
        x = quantities.size();
        if(x==0)
            return;
        System.out.print(quantities.get((quantities.size()-1)));
//        System.out.println(getItems());
        System.out.print(quantities.get((quantities.size()-1)));
    }

    public double calculateTotal() {
        if(items.size()==0)
            return 0.0;
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getprice() * quantities.get(i);
        }
        return total;
    }

    public List<Items> getItems() {
        return items;
    }


        public String getItemNames(Items items , int y) {
          String namess;
                namess=items.getname();
            return namess;
        }
    }



