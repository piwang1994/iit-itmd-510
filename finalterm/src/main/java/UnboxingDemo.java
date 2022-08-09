import java.lang.reflect.Type;

public class UnboxingDemo {
    public static void main(String[] args) {
        Integer i = new Integer(-8);
        
        int result = newValue(i);
        System.out.println(result);
    }
    public static int newValue(int i) {
        return (i < 0) ? -i : i;
    }

}
