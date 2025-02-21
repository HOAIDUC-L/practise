package Exercise1;


 interface Movable {
 void moveUp();
 void moveDown();
 void moveLeft();
 void moveRight();
}

 class MovablePoint implements Movable {
  int x, y, xSpeed, ySpeed; 

  public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
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
      return "(" + x + "," + y + ") Speed=(" + xSpeed + "," + ySpeed + ")";
  }
}
 
 
 class MovableCircle implements Movable {
  private MovablePoint center; 
  private int radius;

  
  public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
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
      return "MovableCircle at " + center + " with radius=" + radius;
  }
}

 class MovableRectangle implements Movable {
  private MovablePoint topLeft;
  private MovablePoint bottomRight;

  public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
      this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
      this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
  }

  @Override
  public void moveUp() {
      topLeft.moveUp();
      bottomRight.moveUp();
  }

  @Override
  public void moveDown() {
      topLeft.moveDown();
      bottomRight.moveDown();
  }

  @Override
  public void moveLeft() {
      topLeft.moveLeft();
      bottomRight.moveLeft();
  }

  @Override
  public void moveRight() {
      topLeft.moveRight();
      bottomRight.moveRight();
  }

  @Override
  public String toString() {
      return "MovableRectangle with topLeft=" + topLeft + " and bottomRight=" + bottomRight;
  }
}
 
public class B68 {
  public static void main(String[] args) {
      Movable m1 = new MovablePoint(5, 6, 10, 15);
      System.out.println(m1);
      m1.moveLeft();
      System.out.println(m1);

      Movable m2 = new MovableCircle(1, 2, 3, 4, 20);
      System.out.println(m2);
      m2.moveRight();
      System.out.println(m2);

      Movable m3 = new MovableRectangle(0, 0, 5, 5, 2, 3);
      System.out.println(m3);
      m3.moveUp();
      System.out.println(m3);
      m3.moveRight();
      System.out.println(m3);
  }
}

