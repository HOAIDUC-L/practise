package Exercise1;

 abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void greets();
}

  class Cat2 extends Animal {

     public Cat2(String name) {
         super(name);
     }

     @Override
     public void greets() {
         System.out.println("Meow");
     }
 }

 class Dog2 extends Animal {

      public Dog2(String name) {
          super(name);
      }

      @Override
      public void greets() {
          System.out.println("Woof");
      }

      public void greets(Dog2 another) {
          System.out.println("Woooof");
      }
  }
 

 class BigDog2 extends Dog2 {

     public BigDog2(String name) {
         super(name);
     }

     @Override
     public void greets() {
         System.out.println("Wooow");
     }

     @Override
     public void greets(Dog2 another) {
         System.out.println("Wooooow");
     }

     public void greets(BigDog2 another) {
         System.out.println("Woooooooow");
     }
 }

 public class B66 {
     public static void main(String[] args) {
         Animal cat = new Cat2("Kitty");
         cat.greets(); 

         Dog2 dog1 = new Dog2("Buddy");
         dog1.greets(); 

         Dog2 dog2 = new Dog2("Charlie");
         dog1.greets(dog2); 

         BigDog2 bigDog1 = new BigDog2("Max");
         bigDog1.greets(); 

         BigDog2 bigDog2 = new BigDog2("Rocky");
         bigDog1.greets(bigDog2); 

         bigDog1.greets(dog1); 
     }
 }


