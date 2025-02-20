package Exercise1;

class Customer {
    private int id;
    private String name;
    private int discount;

    public Customer(int id, String name, int discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + "(" + id + ")(" + discount + "%)";
    }
}

class Invoice {
    private int id;
    private Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return customer.getId();
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public int getCustomerDiscount() {
        return customer.getDiscount();
    }

    public double getAmountAfterDiscount() {
        return amount * (1 - customer.getDiscount() / 100.0);
    }

    @Override
    public String toString() {
        return "Invoice[id=" + id + ", customer=" + customer.toString() + ", amount=" + amount + "]";
    }
}

public class B24 {
    public static void main(String[] args) {
        Customer c1 = new Customer(88, "Tan Ah Teck", 10);
        System.out.println(c1); 

        c1.setDiscount(8);
        System.out.println(c1);
        System.out.println("id là: " + c1.getId());
        System.out.println("tên là: " + c1.getName());
        System.out.println("chiết khấu là: " + c1.getDiscount());

        Invoice inv1 = new Invoice(101, c1, 888.8);
        System.out.println(inv1);

        inv1.setAmount(999.9);
        System.out.println(inv1);
        System.out.println("id là: " + inv1.getId());
        System.out.println("khách hàng là: " + inv1.getCustomer());  
        System.out.println("số tiền là: " + inv1.getAmount());
        System.out.println("ID của khách hàng là: " + inv1.getCustomerId());
        System.out.println("tên khách hàng là: " + inv1.getCustomerName());
        System.out.println("chiết khấu của khách hàng là: " + inv1.getCustomerDiscount());
        System.out.printf("số tiền sau khi giảm giá là: %.2f%n", inv1.getAmountAfterDiscount());
    }
}
