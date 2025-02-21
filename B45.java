package Exercise12;


class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        this.color = "green";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of " + color + " and " + (filled ? "filled" : "Not filled");
    }
}
 class Circle1 extends Shape {
	    private double radius;

	    public Circle1() {
	        this.radius = 1.0;
	    }

	    public Circle1(double radius) {
	        this.radius = radius;
	    }

	    public Circle1(double radius, String color, boolean filled) {
	        super(color, filled);
	        this.radius = radius;
	    }

	    public double getRadius() {
	        return radius;
	    }

	    public void setRadius(double radius) {
	        this.radius = radius;
	    }

	    public double getArea() {
	        return Math.PI * radius * radius;
	    }

	    public double getPerimeter() {
	        return 2 * Math.PI * radius;
	    }

	    @Override
	    public String toString() {
	        return "A Circle with radius=" + radius + ", which is a subclass of " + super.toString();
	    }
	}
 class Rectangle extends Shape {
	    private double width;
	    private double length;

	    public Rectangle() {
	        this.width = 1.0;
	        this.length = 1.0;
	    }

	    public Rectangle(double width, double length) {
	        this.width = width;
	        this.length = length;
	    }

	    public Rectangle(double width, double length, String color, boolean filled) {
	        super(color, filled);
	        this.width = width;
	        this.length = length;
	    }

	    public double getWidth() {
	        return width;
	    }

	    public void setWidth(double width) {
	        this.width = width;
	    }

	    public double getLength() {
	        return length;
	    }

	    public void setLength(double length) {
	        this.length = length;
	    }

	    public double getArea() {
	        return width * length;
	    }

	    public double getPerimeter() {
	        return 2 * (width + length);
	    }

	    @Override
	    public String toString() {
	        return "A Rectangle with width=" + width + " and length=" + length + ", which is a subclass of " + super.toString();
	    }
	}
 class Square extends Rectangle {
	    public Square() {
	        super(1.0, 1.0);
	    }

	    public Square(double side) {
	        super(side, side);
	    }

	    public Square(double side, String color, boolean filled) {
	        super(side, side, color, filled);
	    }

	    @Override
	    public void setWidth(double side) {
	        super.setWidth(side);
	        super.setLength(side);
	    }

	    @Override
	    public void setLength(double side) {
	        super.setLength(side);
	        super.setWidth(side);
	    }

	    @Override
	    public String toString() {
	        return "A Square with side=" + getWidth() + ", which is a subclass of " + super.toString();
	    }
	}
 public class B45 {
	    public static void main(String[] args) {
	        Shape shape = new Shape("blue", false);
	        System.out.println(shape);

	        Circle1 circle = new Circle1(2.5, "red", true);
	        System.out.println(circle);
	        System.out.println("Circle Area: " + circle.getArea());
	        System.out.println("Circle Perimeter: " + circle.getPerimeter());

	        Rectangle rectangle = new Rectangle(3.0, 4.5, "yellow", false);
	        System.out.println(rectangle);
	        System.out.println("Rectangle Area: " + rectangle.getArea());
	        System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());

	        Square square = new Square(5.0, "purple", true);
	        System.out.println(square);
	        System.out.println("Square Area: " + square.getArea());
	        System.out.println("Square Perimeter: " + square.getPerimeter());

	        square.setWidth(7.0);
	        System.out.println("After changing side: " + square);
	    }
	}


