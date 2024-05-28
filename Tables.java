

public class Tables {

    private final int number_of_tables=10;
    private static int number_of_available_tables=10;
    private boolean available;
    private static int table_counter=0;
    private int table_id;


    public Tables() {

        this.table_id=++table_counter;
        number_of_available_tables=number_of_available_tables-1;
    }


    public int getNumber_of_available_tables() {
        return number_of_available_tables;
    }

    public void setNumber_of_available_tables(int number_of_available_tables) {
        this.number_of_available_tables = number_of_available_tables;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static int getTable_counter() {
        return table_counter;
    }

    public static void setTable_counter(int table_counter) {
        Tables.table_counter = table_counter;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    static boolean isavaialbel(){

        if(number_of_available_tables>0){
            return true;
        }
        return false;

    }
    static void table_is_clear(){
         if (number_of_available_tables<10)
          number_of_available_tables++;
        table_counter=table_counter-1;
    }
    static int no_of_available_tables(){
        return number_of_available_tables;

    }
}
