package Exercise1;


class MyIntStack {
    private int[] contents;
    private int tos;  

    public MyIntStack(int capacity) {
        contents = new int[capacity];
        tos = -1;
    }

    public void pushWithException(int element) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        contents[++tos] = element;
    }

    public boolean pushWithBoolean(int element) {
        if (isFull()) {
            return false;
        }
        contents[++tos] = element;
        return true;
    }

    public void pushWithResize(int element) {
        if (isFull()) {
            int newCapacity = contents.length * 2;
            int[] newContents = new int[newCapacity];
            System.arraycopy(contents, 0, newContents, 0, contents.length);
            contents = newContents;
        }
        contents[++tos] = element;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return contents[tos--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return contents[tos];
    }

    public boolean isEmpty() {
        return tos < 0;
    }

    public boolean isFull() {
        return tos == contents.length - 1;
    }

    public int size() {
        return tos + 1;
    }
}
public class B81{
    public static void main(String[] args) {
        MyIntStack stack = new MyIntStack(3);

        System.out.println("Pushing 1, 2, 3");
        stack.pushWithResize(1);
        stack.pushWithResize(2);
        stack.pushWithResize(3);

        System.out.println("Stack full? " + stack.isFull());

        System.out.println("Trying to push 4 (auto-resize)");
        stack.pushWithResize(4);

        System.out.println("Stack full? " + stack.isFull());

        System.out.println("Popping all elements:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        // Uncomment to test exceptions
        // System.out.println(stack.pop()); // Should throw an exception
    }
}