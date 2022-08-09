import java.util.ArrayList;
import java.util.Comparator;

public class StuSort {
    static class Student{
        public String name;
        public double GPA;
        public int   grade;
        public Student(String name,Double GPA,int grade){
            this.name=name;
            this.GPA=GPA;
            this.grade=grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", GPA=" + GPA +
                    ", grade=" + grade +
                    '}';
        }
    }
    static class GPAGradeCmp implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            Student o11 = (Student) o1;
            Student o22 = (Student) o2;
            if(o11.grade!=o22.grade){
                return -1*(o11.grade-o22.grade);
            }else if(o11.GPA!=o22.GPA) {
                return o11.GPA-o22.GPA>0?-1:1;
            }else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("a",2.0,80));
        students.add(new Student("b",3.0,80));
        students.add(new Student("c",3.0,90));
        students.add(new Student("d",2.0,80));
        students.add(new Student("e",4.0,90));
        students.sort(new GPAGradeCmp());
        students.forEach(System.out::println);
    }

}
