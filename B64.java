package Exercise1;

 interface Movable1 {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}


 class MovablePoint1 implements Movable {
     int x, y;
     int xSpeed, ySpeed;

     public MovablePoint1(int x, int y, int xSpeed, int ySpeed) {
         this.x = x;
         this.y = y;
         this.xSpeed = xSpeed;
         this.ySpeed = ySpeed;
     }

     @Override
     public void moveUp() {
         y -= ySpeed;
     }

     @Override
     public void moveDown() {
         y += ySpeed;
     }

     @Override
     public void moveLeft() {
         x -= xSpeed;
     }

     @Override
     public void moveRight() {
         x += xSpeed;
     }

     @Override
     public String toString() {
         return "(" + x + ", " + y + ") speed=(" + xSpeed + ", " + ySpeed + ")";
     }
 }

 class MovableCircle1 implements Movable {
     private int radius;
     private MovablePoint center;

     public MovableCircle1(int x, int y, int xSpeed, int ySpeed, int radius) {
         this.center = new MovablePoint(x, y, xSpeed, ySpeed);
         this.radius = radius;
     }

     @Override
     public void moveUp() {
         center.moveUp();
     }

     @Override
     public void moveDown() {
         center.moveDown();
     }

     @Override
     public void moveLeft() {
         center.moveLeft();
     }

     @Override
     public void moveRight() {
         center.moveRight();
     }

     @Override
     public String toString() {
         return center.toString() + ", radius=" + radius;
     }
 }

 public class B64 {
     public static void main(String[] args) {
         MovablePoint1 p1 = new MovablePoint1(5, 5, 2, 3);
         System.out.println("Initial Point: " + p1);
         
         p1.moveUp();
         System.out.println("After moveUp: " + p1);
         
         p1.moveDown();
         System.out.println("After moveDown: " + p1);
         
         p1.moveLeft();
         System.out.println("After moveLeft: " + p1);
         
         p1.moveRight();
         System.out.println("After moveRight: " + p1);

         System.out.println();

         MovableCircle1 c1 = new MovableCircle1(10, 10, 2, 2, 5);
         System.out.println("Initial Circle: " + c1);
         
         c1.moveUp();
         System.out.println("After moveUp: " + c1);
         
         c1.moveDown();
         System.out.println("After moveDown: " + c1);
         
         c1.moveLeft();
         System.out.println("After moveLeft: " + c1);
         
         c1.moveRight();
         System.out.println("After moveRight: " + c1);
     }
 }

