public class GenericTest {

    public static void main(String[] args) {

        Box<? extends Number> a = new Box<Integer>(712);
//        Box<Number> b = a;  // 1
//        Box<Float> f = new Box<Float>(3.14f);
//        b.setData(f);        // 2

    }

    public static void getData(Box<Number> data) {
        System.out.println("data :" + data.getData());
    }

}

class Box<T> {

    private T data;

    public Box() {

    }

    public Box(T data) {
        setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}