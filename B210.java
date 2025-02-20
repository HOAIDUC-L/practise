package Exercise1;

class MyRectangle {
    private MyPoint topLeft;
    private MyPoint bottomRight;

    // Constructor with coordinates
    public MyRectangle(int x1, int y1, int x2, int y2) {
        this.topLeft = new MyPoint(x1, y1);
        this.bottomRight = new MyPoint(x2, y2);
    }

    // Constructor with MyPoint instances
    public MyRectangle(MyPoint topLeft, MyPoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

   
    public MyPoint getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(MyPoint topLeft) {
        this.topLeft = topLeft;
    }

    public MyPoint getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(MyPoint bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getWidth() {
        return Math.abs(bottomRight.getX() - topLeft.getX());
    }

    public int getHeight() {
        return Math.abs(bottomRight.getY() - topLeft.getY());
    }

    public int getArea() {
        return getWidth() * getHeight();
    }

    public int getPerimeter() {
        return 2 * (getWidth() + getHeight());
    }

    @Override
    public String toString() {
        return "MyRectangle[topLeft=" + topLeft + ", bottomRight=" + bottomRight + "]";
    }
}
public class B210 {
    public static void main(String[] args) {
        MyRectangle rect1 = new MyRectangle(1, 5, 4, 1);
        System.out.println(rect1);
        System.out.println("Width: " + rect1.getWidth());
        System.out.println("Height: " + rect1.getHeight());
        System.out.println("Area: " + rect1.getArea());
        System.out.println("Perimeter: " + rect1.getPerimeter());

        MyPoint p1 = new MyPoint(2, 6);
        MyPoint p2 = new MyPoint(5, 2);
        MyRectangle rect2 = new MyRectangle(p1, p2);
        System.out.println(rect2);
        System.out.println("Width: " + rect2.getWidth());
        System.out.println("Height: " + rect2.getHeight());
        System.out.println("Area: " + rect2.getArea());
        System.out.println("Perimeter: " + rect2.getPerimeter());
    }
}

