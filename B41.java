package Exercise1;

 class Circle {
 private double radius = 1.0;
 private String color = "red";

 public Circle() {}
 public Circle(double radius) {
     this.radius = radius;
 }
 public Circle(double radius, String color) {
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
     return "Circle[radius=" + radius + ",color=" + color + "]";
 }
}

class Cylinder extends Circle {
 private double height = 1.0;

 public Cylinder() {
     super();
 }
 public Cylinder(double height) {
     super();
     this.height = height;
 }
 public Cylinder(double radius, double height) {
     super(radius);
     this.height = height;
 }
 public Cylinder(double radius, double height, String color) {
     super(radius, color);
     this.height = height;
 }
 public double getHeight() {
     return height;
 }
 public void setHeight(double height) {
     this.height = height;
 }
 @Override
 public double getArea() {
     return 2 * Math.PI * getRadius() * height + 2 * super.getArea();
 }
 public double getVolume() {
     return super.getArea() * height;
 }
 @Override
 public String toString() {
     return "Cylinder: subclass of " + super.toString() + " height=" + height;
 }
}

public class B41 {
 public static void main(String[] args) {
     Cylinder c1 = new Cylinder();
     System.out.println(c1);
     System.out.println("Volume=" + c1.getVolume());
     
     Cylinder c2 = new Cylinder(10.0);
     System.out.println(c2);
     System.out.println("Volume=" + c2.getVolume());
     
     Cylinder c3 = new Cylinder(2.0, 10.0);
     System.out.println(c3);
     System.out.println("Volume=" + c3.getVolume());
 }
}
