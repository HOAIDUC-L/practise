package Exercise1;

class MyCircle {
    private MyPoint center;
    private int radius;

    
    public MyCircle(int x, int y, int radius) {
        this.center = new MyPoint(x, y);
        this.radius = radius;
    }

    public MyCircle(MyPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public MyCircle() {
        this.center = new MyPoint(0, 0);
        this.radius = 1;
    }

    
    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getCenterX() {
        return center.getX();
    }

    public void setCenterX(int x) {
        center.setX(x);
    }

    public int getCenterY() {
        return center.getY();
    }

    public void setCenterY(int y) {
        center.setY(y);
    }

    public int[] getCenterXY() {
        return center.getXY();
    }

    public void setCenterXY(int x, int y) {
        center.setXY(x, y);
    }

   
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public double distance(MyCircle another) {
        return center.distance(another.center);
    }

    @Override
    public String toString() {
        return "MyCircle[radius=" + radius + ",center=" + center + "]";
    }
}

public class B28 {
    public static void main(String[] args) {
        
        MyCircle c1 = new MyCircle(3, 4, 5);
        System.out.println(c1);

        MyPoint p1 = new MyPoint(6, 7);
        MyCircle c2 = new MyCircle(p1, 8);
        System.out.println(c2);

        MyCircle c3 = new MyCircle();
        System.out.println(c3);

     
        System.out.println("Center: " + c1.getCenter());
        System.out.println("Radius: " + c1.getRadius());

        c1.setCenter(new MyPoint(10, 10));
        c1.setRadius(15);
        System.out.println("After set: " + c1);

        System.out.println("CenterX: " + c1.getCenterX());
        System.out.println("CenterY: " + c1.getCenterY());

       
        System.out.println("Area: " + c1.getArea());
        System.out.println("Circumference: " + c1.getCircumference());

      
        System.out.println("Distance between c1 and c2: " + c1.distance(c2));
    }
}
