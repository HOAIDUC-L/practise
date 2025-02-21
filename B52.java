package Exercise1;

//Circle class
class Circle3 {
 private double radius;
 private String color;

 // Constructors
 public Circle3() {
     this.radius = 1.0;
     this.color = "red";
 }

 public Circle3(double radius) {
     this.radius = radius;
     this.color = "red";
 }

 public Circle3(double radius, String color) {
     this.radius = radius;
     this.color = color;
 }

 public double getRadius() {
     return radius;
 }

 public void setRadius(double radius) {
     this.radius = radius;
 }

 public String getColor() {
     return color;
 }

 public void setColor(String color) {
     this.color = color;
 }

 
 public double getArea() {
     return Math.PI * radius * radius;
 }


 @Override
 public String toString() {
     return "Circle[radius=" + radius + ", color=" + color + "]";
 }
}

class Cylinder2 {
 private Circle3 base;  
 private double height;

 public Cylinder2() {
     this.base = new Circle3();  // Default Circle
     this.height = 1.0;
 }

 public Cylinder2(double radius, double height) {
     this.base = new Circle3(radius); 
     this.height = height;
 }

 public Cylinder2(double radius, String color, double height) {
     this.base = new Circle3(radius, color);
     this.height = height;
 }

 public double getRadius() {
     return base.getRadius();
 }

 public void setRadius(double radius) {
     base.setRadius(radius);
 }

 public String getColor() {
     return base.getColor();
 }

 public void setColor(String color) {
     base.setColor(color);
 }

 public double getHeight() {
     return height;
 }

 public void setHeight(double height) {
     this.height = height;
 }

 public double getVolume() {
     return base.getArea() * height;
 }

 @Override
 public String toString() {
     return "Cylinder[base=" + base + ", height=" + height + "]";
 }
}


public class B52 {
 public static void main(String[] args) {
     Cylinder2 c1 = new Cylinder2();
     System.out.println(c1);
     System.out.println("Volume: " + c1.getVolume());

     Cylinder2 c2 = new Cylinder2(2.5, 5.0);
     System.out.println(c2);
     System.out.println("Volume: " + c2.getVolume());

     Cylinder2 c3 = new Cylinder2(3.0, "blue", 10.0);
     System.out.println(c3);
     System.out.println("Volume: " + c3.getVolume());
 }
}

