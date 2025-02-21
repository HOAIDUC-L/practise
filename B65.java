package Exercise1;

 interface GeometricObject {
    double getPerimeter();
    double getArea();
}

 class Circle implements GeometricObject {
     protected double radius;

     public Circle(double radius) {
         this.radius = radius;
     }

     @Override
     public double getPerimeter() {
         return 2 * Math.PI * radius;
     }

     @Override
     public double getArea() {
         return Math.PI * radius * radius;
     }

     @Override
     public String toString() {
         return "Circle[radius=" + radius + "]";
     }
 }

  interface Resizable {
     void resize(int percent);
 }


  class ResizableCircle extends Circle implements Resizable {

      public ResizableCircle(double radius) {
          super(radius);
      }

      @Override
      public void resize(int percent) {
          radius *= percent / 100.0;
      }

      @Override
      public String toString() {
          return "ResizableCircle[Circle[radius=" + radius + "]]";
      }
  }

 public class B65 {
     public static void main(String[] args) {
         Circle c1 = new Circle(5.0);
         System.out.println("Initial Circle: " + c1);
         System.out.println("Area: " + c1.getArea());
         System.out.println("Perimeter: " + c1.getPerimeter());
         
         ResizableCircle rc1 = new ResizableCircle(10.0);
         System.out.println("Initial ResizableCircle: " + rc1);
         System.out.println("Area: " + rc1.getArea());
         System.out.println("Perimeter: " + rc1.getPerimeter());

         rc1.resize(50);
         System.out.println("After resizing by 50%: " + rc1);
         System.out.println("Area: " + rc1.getArea());
         System.out.println("Perimeter: " + rc1.getPerimeter());

         rc1.resize(200);
         System.out.println("After resizing by 200%: " + rc1);
         System.out.println("Area: " + rc1.getArea());
         System.out.println("Perimeter: " + rc1.getPerimeter());
     }
 }
