package Exercise1;

class Author1 {
 private String name;
 private String email;
 private char gender;

 public Author1(String name, String email, char gender) {
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

class Book1 {
 private String name;
 private Author1[] authors;
 private double price;
 private int qty = 0;

 public Book1(String name, Author1[] authors, double price) {
     this.name = name;
     this.authors = authors;
     this.price = price;
 }

 public Book1(String name, Author1[] authors, double price, int qty) {
     this.name = name;
     this.authors = authors;
     this.price = price;
     this.qty = qty;
 }

 public String getName() {
     return name;
 }

 public Author1[] getAuthors() {
     return authors;
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
 public String getAuthorNames() {
     StringBuilder names = new StringBuilder();
     for (Author1 author : authors) {
         names.append(author.getName()).append(", ");
     }
     return names.substring(0, names.length() - 2);
 }

 @Override
 public String toString() {
     StringBuilder authorsStr = new StringBuilder("{");
     for (Author1 author : authors) {
         authorsStr.append(author.toString()).append(", ");
     }
     authorsStr.setLength(authorsStr.length() - 2);
     authorsStr.append("}");
     return "Book[name=" + name + ",authors=" + authorsStr + ",price=" + price + ",qty=" + qty + "]";
 }
}

public class B22 {
 public static void main(String[] args) {
    
     Author1[] authors = new Author1[2];
     authors[0] = new Author1("Tan Ah Teck", "AhTeck@somewhere.com", 'm');
     authors[1] = new Author1("Paul Tan", "Paul@nowhere.com", 'm');

     System.out.println(authors[0]);
     System.out.println(authors[1]);

     Book1 javaDummy = new Book1("Java for Beginners", authors, 19.99, 99);
     System.out.println(javaDummy);
 }
}

