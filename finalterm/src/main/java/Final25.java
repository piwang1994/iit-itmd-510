import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Final25 {

    public static Queue<Integer> interChanger(Queue<Integer> q) {


        Stack<Integer> st = new Stack<Integer>();



        int size = q.size()/2;

        for(int i = 1; i <= size; i++){

            st.push(q.remove());    //1. ____________

        }

        while(!st.isEmpty()){

            q.add(st.pop());          //2. ____________

        }

        for(int i = 1; i <= size; i++){

            q.add(q.remove());     //3. ____________

        }

        for(int i = 1; i <= size; i++){

            st.push(q.remove());   //4. ____________

        }

        while(!st.isEmpty()){

            q.add(st.pop());

            q.add(q.remove());     //5. ____________

        }

        return q;

    }

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(10);
        queue.add(9);
        queue.add(8);
        queue.add(7);
        queue.add(6);
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);
        System.out.println(interChanger(queue));
    }
}
