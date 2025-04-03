package b;

//Nếu không đồng bộ hóa, kết quả có thể nhỏ hơn 2000 do điều kiện tranh chấp (race condition).
//Sau khi sửa lỗi bằng synchronized, kết quả luôn là 2000.
class Counter {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}

public class Bai1 {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final counter value: " + c.getCounter()); // Phải là 2000
    }
}

