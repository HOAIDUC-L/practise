package Exercise1;

class Customer1 {
    private int id;
    private String name;
    private char gender;

    public Customer1(int id, String name, char gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name + "(" + id + ")";
    }
}

class Account1 {
    private int id;
    private Customer1 customer;
    private double balance = 0.0;

    public Account1(int id, Customer1 customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public Account1(int id, Customer1 customer) {
        this.id = id;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Customer1 getCustomer1() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomer1Name() {
        return customer.getName();
    }

    public Account1 deposit(double amount) {
        balance += amount;
        return this;
    }

    public Account1 withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Số tiền rút vượt quá số dư hiện tại!");
        }
        return this;
    }

    @Override
    public String toString() {
        return customer.toString() + " balance=$" + String.format("%.2f", balance);
    }
}

public class B25 {
    public static void main(String[] args) {
      
        Customer1 c1 = new Customer1(88, "Tan Ah Teck", 'm');
        System.out.println(c1); 

        Account1 acc1 = new Account1(101, c1, 1000.0);
        System.out.println(acc1);

        acc1.deposit(500);
        System.out.println(acc1);

        acc1.withdraw(200);
        System.out.println(acc1);

        acc1.withdraw(2000);
        System.out.println(acc1);

        System.out.println("ID tài khoản: " + acc1.getId());
        System.out.println("Khách hàng: " + acc1.getCustomer1());
        System.out.println("Tên khách hàng: " + acc1.getCustomer1Name());
        System.out.println("Số dư tài khoản: $" + String.format("%.2f", acc1.getBalance()));
    }
}

