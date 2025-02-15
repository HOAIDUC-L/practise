package Exercise1;

	public class Circle {
	    private double radius;
	    private String color;

	    public Circle() {
	        this.radius = 1.0;
	        this.color = "red";
	    }

	    public Circle(double radius) {
	        this.radius = radius;
	        this.color = "red";
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
	        return radius * radius * Math.PI;
	    }

	    @Override
	    public String toString() {
	        return "Circle[radius=" + radius + ", color=" + color + "]";
	    }
	
	   
	public static void main(String[] args) {
	      Circle c1 = new Circle();
	      System.out.println("The circle has radius of " 
	         + c1.getRadius() + " and area of " + c1.getArea());
	      
	      Circle c2 = new Circle(2.0);
	      System.out.println("The circle has radius of " 
	         + c2.getRadius() + " and area of " + c2.getArea());
	      
	      Circle c4 = new Circle();  
	      c4.setRadius(5.5);          
	      System.out.println("radius is: " + c4.getRadius()); 
	      c4.setColor("green");       
	      System.out.println("color is: " + c4.getColor());  
	      
	      Circle c5 = new Circle(5.5);
	      System.out.println(c5.toString());
	      
	      Circle c6 = new Circle(6.6);
	      System.out.println(c6.toString());  

	      Circle c3 = new Circle(3.0, "blue");
	        System.out.println("Circle 3: " + c3);
	        
	        System.out.println("Diện tích của Circle 3: " + c3.getArea());

	   
	}

	public Object getCircumference() {
		// TODO Auto-generated method stub
		return null;
	}

}

