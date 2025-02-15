package Exercise1;

public class Circle2 {
    private double radius = 1.0; 
    
    public Circle2() {
    }

    public Circle2(double radius) {
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

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + "]";
    }


    public static void main(String[] args) {
        Circle2 c1 = new Circle2(1.1);
        System.out.println(c1);   
        Circle2 c2 = new Circle2();
        System.out.println(c2);

        c1.setRadius(2.2);
        System.out.println(c1);     
        System.out.println("radius is: " + c1.getRadius());


        System.out.printf("area is: %.2f%n", c1.getArea());
        System.out.printf("circumference is: %.2f%n", c1.getCircumference());
     }
}

