package Exercise12;

 class Point2D {
 private float x = 0.0f;
 private float y = 0.0f;

 public Point2D() {}

 public Point2D(float x, float y) {
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

 class Point3D extends Point2D {
 private float z = 0.0f;

 public Point3D() {}

 public Point3D(float x, float y, float z) {
     super(x, y);
     this.z = z;
 }

 public float getZ() {
     return z;
 }

 public void setZ(float z) {
     this.z = z;
 }

 public void setXYZ(float x, float y, float z) {
     setX(x);
     setY(y);
     this.z = z;
 }

 public float[] getXYZ() {
     return new float[]{getX(), getY(), z};
 }

 @Override
 public String toString() {
     return "(" + getX() + "," + getY() + "," + z + ")";
 }
}
 public class B43 {
	    public static void main(String[] args) {
	        Point2D p2d = new Point2D(3.5f, 4.5f);
	        System.out.println("Point2D: " + p2d);
	        System.out.println("XY Array: " + java.util.Arrays.toString(p2d.getXY()));

	        Point3D p3d = new Point3D(1.2f, 3.4f, 5.6f);
	        System.out.println("Point3D: " + p3d);
	        System.out.println("XYZ Array: " + java.util.Arrays.toString(p3d.getXYZ()));

	     
	        p3d.setXYZ(7.8f, 9.1f, 2.3f);
	        System.out.println("Updated Point3D: " + p3d);
	        System.out.println("Updated XYZ Array: " + java.util.Arrays.toString(p3d.getXYZ()));
	    }
	}

