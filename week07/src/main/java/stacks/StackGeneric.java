package stacks;//Generic Stack.java

import java.util.Arrays;

public class StackGeneric<T> {
    private int count;
    private T[] data;

    public StackGeneric() {
        data = (T[]) new Object[8];
        count = 0;
    }

    public static void main(String[] args) throws Exception {
        StackGeneric<String> s = new StackGeneric<String>();
        s.push("Alice");
        s.push("Bob");
        s.push("Carl");
        s.push("Dave");
        StackGeneric<Integer> i = new StackGeneric<>();
        i.push(1);
        i.push(22);


        while (!s.isEmpty())
            System.out.println(s.pop());
    }

    void expandCapacity() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    void push(T e) {
        if (count == data.length)
            expandCapacity();
        data[count++] = e;
    }

    T pop() throws Exception {
        if (count <= 0) {
            throw new Exception("stack empty");
        }
        count--;
        return data[count];
    }

    boolean isEmpty() {
        return count == 0;
    }

    int size() {
        return count;
    }
}