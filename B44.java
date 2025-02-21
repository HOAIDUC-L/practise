package Exercise12;


class Point {
   private float x = 0.0f;
   private float y = 0.0f;

   public Point() {}

   public Point(float x, float y) {
       this.x = x;
       this.y = y;
   }

   public float getX() {
       return x;
   }

   public void setX(float x) {
       this.x = x;
   }

   public float getY() {
       return y;
   }

   public void setY(float y) {
       this.y = y;
   }

   public void setXY(float x, float y) {
       this.x = x;
       this.y = y;
   }

   public float[] getXY() {
       return new float[]{x, y};
   }

   @Override
   public String toString() {
       return "(" + x + "," + y + ")";
   }
}
class MovablePoint extends Point {
   private float xSpeed = 0.0f;
   private float ySpeed = 0.0f;

   public MovablePoint() {}

   public MovablePoint(float xSpeed, float ySpeed) {
       this.xSpeed = xSpeed;
       this.ySpeed = ySpeed;
   }

   public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
       super(x, y);
       this.xSpeed = xSpeed;
       this.ySpeed = ySpeed;
   }

   public float getXSpeed() {
       return xSpeed;
   }

   public void setXSpeed(float xSpeed) {
       this.xSpeed = xSpeed;
   }

   public float getYSpeed() {
       return ySpeed;
   }

   public void setYSpeed(float ySpeed) {
       this.ySpeed = ySpeed;
   }

   public void setSpeed(float xSpeed, float ySpeed) {
       this.xSpeed = xSpeed;
       this.ySpeed = ySpeed;
   }

   public float[] getSpeed() {
       return new float[]{xSpeed, ySpeed};
   }

   @Override
   public String toString() {
       return super.toString() + ", speed=(" + xSpeed + "," + ySpeed + ")";
   }

   public MovablePoint move() {
       setX(getX() + xSpeed);
       setY(getY() + ySpeed);
       return this;
   }
}
public class B44 {
	    public static void main(String[] args) {
	        Point p1 = new Point(3.5f, 5.5f);
	        System.out.println("Point: " + p1);

	        MovablePoint mp1 = new MovablePoint(2.0f, 3.0f, 1.0f, 1.5f);
	        System.out.println("MovablePoint (Before move): " + mp1);

	        mp1.move();
	        System.out.println("MovablePoint (After move): " + mp1);
	    }
	}



