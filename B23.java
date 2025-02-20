package Exercise1;

class Author2 {
    private String name;
    private String email;

    public Author2(String name, String email) {
        this.name = name;
        this.email = email;
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

    @Override
    public String toString() {
        return "Author[name=" + name + ", email=" + email + "]";
    }
}

class Book2 {
    private String isbn;
    private String name;
    private Author2 author;
    private double price;
    private int qty;

    public Book2(String isbn, String name, Author2 author, double price, int qty) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public Author2 getAuthor() {
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

    public String getAuthorName() {
        return author.getName();
    }

    @Override
    public String toString() {
        return "Book[isbn=" + isbn + ", name=" + name + ", " + author.toString() +
                ", price=" + price + ", qty=" + qty + "]";
    }
}

public class B23 {
    public static void main(String[] args) {
        Author2 a1 = new Author2("Tan Ah Teck", "ahteck@nowhere.com");
        System.out.println(a1);

        a1.setEmail("ahteck@somewhere.com");
        System.out.println(a1);
        System.out.println("Tên là: " + a1.getName());
        System.out.println("Email là: " + a1.getEmail());

        Book2 b1 = new Book2("12345", "Java for Beginners", a1, 8.8, 88);
        System.out.println(b1);

        b1.setPrice(9.9);
        b1.setQty(99);
        System.out.println(b1);
        System.out.println("ISBN là: " + b1.getIsbn());
        System.out.println("Tên sách là: " + b1.getName());
        System.out.println("Giá là: " + b1.getPrice());
        System.out.println("Số lượng là: " + b1.getQty());
        System.out.println("Tác giả là: " + b1.getAuthor());
        System.out.println("Tên tác giả: " + b1.getAuthorName());
        System.out.println("Email của tác giả: " + b1.getAuthor().getEmail());
    }
}
