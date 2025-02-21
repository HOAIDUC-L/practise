package Exercise1;

abstract class Animal2 {
    abstract public void greeting();
}

class Cat extends Animal2 {
    @Override
    public void greeting() {
        System.out.println("Meow!");
    }
}

class Dog extends Animal2 {
    @Override
    public void greeting() {
        System.out.println("Woof!");
    }

    public void greeting(Dog another) {
        System.out.println("Woooooooooof!");
    }
}

class BigDog extends Dog {
    @Override
    public void greeting() {
        System.out.println("Woow!");
    }

    @Override
    public void greeting(Dog another) {
        System.out.println("Woooooowwwww!");
    }
}

public class B67 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.greeting();

        Dog dog1 = new Dog();
        dog1.greeting();

        BigDog bigDog1 = new BigDog();
        bigDog1.greeting();

        Animal2 animal1 = new Cat();
        animal1.greeting();

        Animal2 animal2 = new Dog();
        animal2.greeting();

        Animal2 animal3 = new BigDog();
        animal3.greeting();

        // Không thể tạo đối tượng từ lớp trừu tượng
        // Animal2 animal4 = new Animal2(); // Lỗi biên dịch

        Dog dog2 = (Dog) animal2;
        BigDog bigDog2 = (BigDog) animal3;
        Dog dog3 = (Dog) animal3;

        if (animal2 instanceof Cat) {
            Cat cat2 = (Cat) animal2;
        } else {
            System.out.println("animal2 không phải là Cat, không thể ép kiểu!");
        }

        dog2.greeting(dog3);
        dog3.greeting(dog2);
        dog2.greeting(bigDog2);
        bigDog2.greeting(dog2);
        bigDog2.greeting(bigDog1);
    }
}
