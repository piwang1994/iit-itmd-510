import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayBasedStack {
    /*
    1、define the init capacity and it is fixed as 100
    2、 ArrayBasedStack can only store string class
    * */
    String[] s = new String[100];
    int top = 0;
    public void add(String ele){
        if (top<100) {
            s[top++] = ele;
        }else {
            throw new IndexOutOfBoundsException("up to capacity");
        }
    }
    public String pop(){
        if(top>0){
            return s[--top];
        }else {
            throw new IndexOutOfBoundsException("empty,no ele");
        }
    }
    @Test
    public  void test1() {
        ArrayBasedStack arrStack = new ArrayBasedStack();
        arrStack.add("a");
        arrStack.add("b");
        arrStack.add("c");
        String pop = arrStack.pop();
        System.out.println(pop);
        arrStack.add("b");
        System.out.println(arrStack.pop());
        System.out.println(arrStack.pop());
        System.out.println(arrStack.pop());
        System.out.println(arrStack.pop());

    }
    @Test
    public  void test2() {
        ArrayBasedStack arrStack = new ArrayBasedStack();

        for(int i=0;i<200;i++){
            arrStack.add("a");
        }
    }


//    public static int myList(ArrayList<Integer> arr) {
//        return arr.stream().mapToInt(x->x).sum();
//    }
    public static int myList(ArrayList<Integer> arr) throws Exception {
        int mist=Integer.MIN_VALUE;
        if(arr.size()==0){
            throw new Exception("empty,no greatest value");
        }
        for (Integer integer : arr) {
            mist=integer>mist ? integer:mist;

        }
        return mist;
    }
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> all = new ArrayList<>();
        all.add(11);
        all.add(122);
        all.add(113);
        System.out.println(myList(all));


        ArrayList<Integer> all2 = new ArrayList<>();
        all2.add(11222);
        all2.add(122);
        all2.add(113);
        System.out.println(myList(all2));

        ArrayList<Integer> all3 = new ArrayList<>();

        System.out.println(myList(all3));
    }
}
