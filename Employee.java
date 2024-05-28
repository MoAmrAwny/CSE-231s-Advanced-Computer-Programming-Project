
abstract public class Employee
{


      protected  int salary;
      protected   String name;
      protected   int age;
      protected   int ID;
      protected   String password;

      public  abstract String display_info();
      public  abstract void CheckIn();
      public  abstract void CheckOut();

        public Employee() {
                this.salary = salary;
                this.name = name;
                this.age = age;
                this.ID = ID;
                this.password = password;
        }

        public Employee( String name, int age, int ID, String password,int salary) {
                this.salary = salary;
                this.name = name;
                this.age = age;
                this.ID = ID;
                this.password = password;
        }

        public int getSalary() {
                return salary;
        }

        public void setSalary(int salary) {
                this.salary = salary;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public int getID() {
                return ID;
        }

        public void setID(int ID) {
                this.ID = ID;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}

