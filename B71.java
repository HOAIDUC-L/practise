package Exercise1;

import java.util.Date;
 

 class DiscountRate {
    private static final double SERVICE_DISCOUNT_PREMIUM = 0.2;
    private static final double SERVICE_DISCOUNT_GOLD = 0.15;
    private static final double SERVICE_DISCOUNT_SILVER = 0.1;
    private static final double PRODUCT_DISCOUNT = 0.1; 

    public static double getServiceDiscountRate(String membershipType) {
        if (membershipType == null) return 0.0;
        switch (membershipType.toLowerCase()) {
            case "premium": return SERVICE_DISCOUNT_PREMIUM;
            case "gold": return SERVICE_DISCOUNT_GOLD;
            case "silver": return SERVICE_DISCOUNT_SILVER;
            default: return 0.0;
        }
    }

    public static double getProductDiscountRate(String membershipType) {
        if (membershipType == null) return 0.0;
        return (membershipType.equalsIgnoreCase("premium") ||
                membershipType.equalsIgnoreCase("gold") ||
                membershipType.equalsIgnoreCase("silver")) ? PRODUCT_DISCOUNT : 0.0;
    }
}
class Customer3 {
    private String name;
    private boolean member = false;
    private String memberType = "None"; 

    public Customer3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
        if (!member) {
            this.memberType = "None"; 
        }
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        if (member && (memberType.equalsIgnoreCase("Premium") ||
                       memberType.equalsIgnoreCase("Gold") ||
                       memberType.equalsIgnoreCase("Silver"))) {
            this.memberType = memberType;
        } else {
            this.memberType = "None"; 
        }
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', member=" + member + ", memberType='" + memberType + "'}";
    }
}

 class Visit1 {
    private Customer3 customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit1(String customerName, Date date) {
        this.customer = new Customer3(customerName);
        this.date = date;
        this.serviceExpense = 0.0;
        this.productExpense = 0.0;
    }

    public String getName() {
        return customer.getName();
    }

    public void setServiceExpense(double expense) {
        this.serviceExpense = expense;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setProductExpense(double expense) {
        this.productExpense = expense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public double getTotalExpense() {
        double serviceDiscount = DiscountRate.getServiceDiscountRate(customer.getMemberType());
        double productDiscount = DiscountRate.getProductDiscountRate(customer.getMemberType());

        double totalServiceCost = serviceExpense * (1 - serviceDiscount);
        double totalProductCost = productExpense * (1 - productDiscount);

        return totalServiceCost + totalProductCost;
    }

    @Override
    public String toString() {
        return "Visit{customer=" + customer + ", date=" + date + 
               ", serviceExpense=" + serviceExpense + 
               ", productExpense=" + productExpense + 
               ", totalExpense=" + getTotalExpense() + "}";
    }
}


 public class B71 {
     public static void main(String[] args) {
         Customer3 customer1 = new Customer3("Alice");
         customer1.setMember(true);
         customer1.setMemberType("Premium");

         Visit1 visit1 = new Visit1(customer1.getName(), new Date());
         visit1.setServiceExpense(100.0);
         visit1.setProductExpense(50.0);

         System.out.println(visit1); 

   
         Customer3 customer2 = new Customer3("Bob");
         Visit1 visit2 = new Visit1(customer2.getName(), new Date());
         visit2.setServiceExpense(200.0);
         visit2.setProductExpense(100.0);

         System.out.println(visit2); 
     }
 }
