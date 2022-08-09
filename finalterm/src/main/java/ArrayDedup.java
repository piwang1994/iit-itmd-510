import java.util.Arrays;
import java.util.LinkedList;

public class ArrayDedup {
    public static Integer[] deDup(){
        Integer[] ints=new Integer[] {2,3,6,6,8,9,10,10,10,12,12};
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i=1;i<=ints.length-1;i++){
            if(i==0||ints[i]!=ints[i-1]){
                integers.add(ints[i]);
            }
        }
        return integers.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deDup()));
    }
}
