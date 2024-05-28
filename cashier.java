
import java.time.LocalDateTime;


public class cashier extends Employee {



    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public cashier(  String name, int age, int ID, String password,int salary) {

        super(  name,  age,  ID,  password , salary);
    }

    @Override
    public String display_info() {
        return "cashier{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ID=" + ID +
                ", salary=" + salary +
                '}';
    }

    @Override
    public  void CheckIn(){

        checkInTime = LocalDateTime.now();
        System.out.println("Cashier checked in at: " + checkInTime);


    }
    @Override
   public  void CheckOut(){


    checkOutTime = LocalDateTime.now();
    System.out.println("Cashier checked out at" +checkOutTime);


    }

}

