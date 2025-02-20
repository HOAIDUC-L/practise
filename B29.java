package Exercise1;

class MyTriangle {
    private MyPoint v1, v2, v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1 = new MyPoint(x1, y1);
        this.v2 = new MyPoint(x2, y2);
        this.v3 = new MyPoint(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle[v1=" + v1 + ", v2=" + v2 + ", v3=" + v3 + "]";
    }

    public double getPerimeter() {
        double side1 = v1.distance(v2);
        double side2 = v2.distance(v3);
        double side3 = v3.distance(v1);
        return side1 + side2 + side3;
    }

    public void printType() {
        double side1 = v1.distance(v2);
        double side2 = v2.distance(v3);
        double side3 = v3.distance(v1);

        if (side1 == side2 && side2 == side3) {
            System.out.println("equilateral");
        } else if (side1 == side2 || side2 == side3 || side3 == side1) {
            System.out.println("isosceles");
        } else {
            System.out.println("scalene");
        }
    }
}

public class B29 {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(4, 0);
        MyPoint p3 = new MyPoint(2, 3);

        MyTriangle t1 = new MyTriangle(p1, p2, p3);
        System.out.println(t1);

        MyTriangle t2 = new MyTriangle(1, 1, 4, 5, 7, 1);
        System.out.println(t2);

        System.out.println("Perimeter of t1: " + t1.getPerimeter());
        System.out.println("Perimeter of t2: " + t2.getPerimeter());

        System.out.print("Type of t1: ");
        t1.printType();

        System.out.print("Type of t2: ");
        t2.printType();
    }
}
