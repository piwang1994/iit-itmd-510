package stacks;//Stack.java

import java.util.Arrays;

public class Stack {
    private int count;
    private String[] data;

    public Stack() {
        data = new String[8];
        count = 0;
    }

    public static void main(String[] args) throws Exception {
        Stack s = new Stack();
        s.push("Alice");
        s.push("Bob");
        s.push("Carl");
        s.push("Dave");

        while (!s.isEmpty())
            System.out.println(s.pop());

    }

    void expandCapacity() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    void push(String e) {
        if (count == data.length)
            expandCapacity();
        data[count++] = e;
    }

    String pop() throws Exception {
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