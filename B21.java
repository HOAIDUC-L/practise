package Exercise1;


class Author {
 private String name;
 private String email;
 private char gender;


 public Author(String name, String email, char gender) {
     this.name = name;
     this.email = email;
     this.gender = gender;
 }


 public String getName() {
     return name;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public char getGender() {
     return gender;
 }

 @Override
 public String toString() {
     return "Author[name=" + name + ",email=" + email + ",gender=" + gender + "]";
 }
}


class Book {
 private String name;
 private Author author;
 private double price;
 private int qty = 0;

 public Book(String name, Author author, double price) {
     this.name = name;
     this.author = author;
     this.price = price;
 }

 public Book(String name, Author author, double price, int qty) {
     this.name = name;
     this.author = author;
     this.price = price;
     this.qty = qty;
 }

 public String getName() {
     return name;
 }

 public Author getAuthor() {
     return author;
 }

 public double getPrice() {
     return price;
 }

 public void setPrice(double price) {
     this.price = price;
 }

 public int getQty() {
     return qty;
 }

 public void setQty(int qty) {
     this.qty = qty;
 }

 // New methods for accessing Author information
 public String getAuthorName() {
     return author.getName();
 }

 public String getAuthorEmail() {
     return author.getEmail();
 }

 public char getAuthorGender() {
     return author.getGender();
 }

 // toString method
 @Override
 public String toString() {
     return "Book[name=" + name + "," + author.toString() + ",price=" + price + ",qty=" + qty + "]";
 }
}

//Test class
public class B21 {
 public static void main(String[] args) {
     // Kiểm tra lớp Author
     Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
     System.out.println(ahTeck);
     ahTeck.setEmail("paulTan@nowhere.com");
     System.out.println("name is: " + ahTeck.getName());
     System.out.println("email is: " + ahTeck.getEmail());
     System.out.println("gender is: " + ahTeck.getGender());

     // Kiểm tra lớp Book
     Book dummyBook = new Book("Java for Dummy", ahTeck, 19.95, 99);
     System.out.println(dummyBook);

     dummyBook.setPrice(29.95);
     dummyBook.setQty(28);
     System.out.println("tên là: " + dummyBook.getName());
     System.out.println("giá là: " + dummyBook.getPrice());
     System.out.println("số lượng là: " + dummyBook.getQty());
     System.out.println("Tác giả là: " + dummyBook.getAuthor());
     System.out.println("Tên tác giả là: " + dummyBook.getAuthorName());
     System.out.println("Email của tác giả là: " + dummyBook.getAuthorEmail());

     // Dùng Author ẩn danh
     Book anotherBook = new Book("More Java", new Author("Paul Tan", "paul@somewhere.com", 'm'), 29.95);
     System.out.println(anotherBook);
 }
}

