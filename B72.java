package Exercise1;
import java.util.*;

 class Point2 {
    private int x;
    private int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        return new int[]{x, y};
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public double distance(Point2 another) {
        int dx = this.x - another.x;
        int dy = this.y - another.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

 class PolyLine {
     private List<Point2> points;   

     public PolyLine() {
         points = new ArrayList<Point2>(); 
     }

    
     public PolyLine(List<Point2> points) {
         this.points = new ArrayList<>(points);
     }

     
     public void appendPoint(int x, int y) {
         points.add(new Point2(x, y));
     }

     
     public void appendPoint(Point2 point) {
         points.add(point);
     }

     
     public double getLength() {
         double length = 0.0;
         for (int i = 1; i < points.size(); i++) {
             length += points.get(i - 1).distance(points.get(i));
         }
         return length;
     }

     
     @Override
     public String toString() {
         StringBuilder sb = new StringBuilder("{");
         for (Point2 p : points) {
             sb.append(p.toString());
         }
         sb.append("}");
         return sb.toString();
     }
 }
 

 public class B72 {
     public static void main(String[] args) {
         PolyLine l1 = new PolyLine();
         System.out.println(l1);  
         l1.appendPoint(new Point2(1, 2));
         l1.appendPoint(3, 4);
         l1.appendPoint(5, 6);
         System.out.println(l1);  

         List<Point2> points = new ArrayList<>();
         points.add(new Point2(11, 12));
         points.add(new Point2(13, 14));
         PolyLine l2 = new PolyLine(points);
         System.out.println(l2);  

         System.out.println("Độ dài đường gấp khúc l1: " + l1.getLength());
         System.out.println("Độ dài đường gấp khúc l2: " + l2.getLength());
     }
 }

