package Exercise12;

class Animal {
 protected String name;

 public Animal(String name) {
     this.name = name;
 }

 @Override
 public String toString() {
     return "Animal[name=" + name + "]";
 }
}

class Mammal extends Animal {
 public Mammal(String name) {
     super(name);
 }

 @Override
 public String toString() {
     return "Mammal[" + super.toString() + "]";
 }
}

class Cat extends Mammal {
 public Cat(String name) {
     super(name);
 }

 public void greets() {
     System.out.println("Meow");
 }

 @Override
 public String toString() {
     return "Cat[" + super.toString() + "]";
 }
}

class Dog extends Mammal {
 public Dog(String name) {
     super(name);
 }

 public void greets() {
     System.out.println("Woof");
 }

 public void greets(Dog another) {
     System.out.println("Woooof");
 }

 @Override
 public String toString() {
     return "Dog[" + super.toString() + "]";
 }
}

public class B46 {
 public static void main(String[] args) {
     Animal animal = new Animal("Generic Animal");
     System.out.println(animal);

     Mammal mammal = new Mammal("Mammal");
     System.out.println(mammal);

     Cat cat = new Cat("Kitty");
     System.out.println(cat);
     cat.greets();

     Dog dog1 = new Dog("Buddy");
     System.out.println(dog1);
     dog1.greets();

     Dog dog2 = new Dog("Max");
     dog1.greets(dog2);
 }
}