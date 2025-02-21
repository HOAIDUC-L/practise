package Exercise1;

 interface GeometricObject {
    double getArea();
    double getPerimeter();
}

 class Circle5 implements GeometricObject {
	    private double radius;

	    public Circle5(double radius) {
	        this.radius = radius;
	    }

	    public double getRadius() {
	        return radius;
	    }

	    public void setRadius(double radius) {
	        this.radius = radius;
	    }

	    @Override
	    public double getArea() {
	        return Math.PI * radius * radius;
	    }

	    @Override
	    public double getPerimeter() {
	        return 2 * Math.PI * radius;
	    }

	    @Override
	    public String toString() {
	        return "Circle[radius=" + radius + "]";
	    }
	}
 public class B62 {
	    public static void main(String[] args) {
	        GeometricObject c1 = new Circle5(5.0);
	        System.out.println(c1);
	        System.out.println("Area: " + c1.getArea());
	        System.out.println("Perimeter: " + c1.getPerimeter());
	    }
	}

