
enum paymentType{CASH, VISA};


public class Payments {

    private Order order;
    private Tables tables;
    private String d;
    private double total_price ;
    private paymentType typeOfPayment;
    private double paidmoney;
    private double change =0;
    private final double deliveryfees =20;

    public paymentType getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(paymentType typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }


    public double getTotal_price() {
        return order.calculateTotal();
    }


    public double getPaidmoney() {
        return paidmoney;
    }

    public double getChange() {
        return change;
    }

    public double getDeliveryfees() {
        return deliveryfees;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }



    public void setPaidmoney(double paidmoney) {
        this.paidmoney = paidmoney;
    }

    // public void setChange(double change) {
    //   this.change = change;
    //}



    public Payments(Order order, Tables tables) {
        this.order = order;
        this.tables = tables;
    }
    public Payments(Order order) {
        this.order = order;

    }

    public double makePayment(double paidMoney, paymentType typeOfPayment, boolean deliveryType) {
        double totalPrice = order.calculateTotal();
        //this.total_price=order.calculateTotal();
        if (deliveryType) { /////ignore case means that both of t and T is accepted/////
            System.out.println("Payment accepted. Total price (including delivery fees): $" + (totalPrice + deliveryfees));
            if (typeOfPayment == paymentType.VISA) {
                System.out.println("Payment type: VISA");

                this.total_price=(totalPrice + deliveryfees)*0.9;
                //totalPrice = this.total_price;////discount
            } else {
                this.total_price=(totalPrice + deliveryfees);
                System.out.println("Payment type: CASH");

            }
            if (paidMoney >= (totalPrice + deliveryfees)) {
                this.change = paidMoney - this.total_price;
                System.out.println("Change: $" + change);

            } else {
                System.out.println("Insufficient payment.");

            }
        }
        if(!(deliveryType)) {
            if (typeOfPayment == paymentType.VISA) {
                totalPrice = totalPrice * 0.9;
                System.out.println("Payment type: VISA");
            } else {
                System.out.println("Payment type: CASH");
            }
            if (paidMoney >= totalPrice) {
                this.change = paidMoney - totalPrice;
                System.out.println("Change: $" + change);
            } else {
                System.out.println("Insufficient payment.");
            }
        }


        return this.change;
    }
}


