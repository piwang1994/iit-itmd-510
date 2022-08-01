package Derived;

class Base {

    private int a;
    protected int b;
    public Base() {
        System.out.println("Base constructor fired!!");
    }
    public Base(int a) {
        this.setA(a);
        b=a;
        System.out.println("Base member value for a " + a);
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public void printAll() {
        System.out.println("A and B from the Base " + a + " " + b);
    }
    /*
     * override
     */
    public String toString() {
        return ("Data members summed in based " + (a + b));
    }
    
}

public class Derived extends Base{
    
    public Derived(int a) {
        super(a);  //EXPLICITLY CALL PARENT (BASE FIRST TO EXECUTE!!!)
        System.out.println("Derived constructor fired!!");
    
    }
    public void printBase() {
        //super.printAll();  //OVERRIDE
        printAll();
    }
    public void printAll() {
        return;
    }
    /*
     * override
     */
    public String toString() {
        return (super.toString() + "\nData members summed in derived " + (getA() + b));
    }
    
    public static void main(String a[]) {
    
    Base bobj = new Base();
    Derived dobj = new Derived(5);
    System.out.println("Value in base for a " + dobj.getA());
    System.out.println("Value in base for b " + dobj.b); //OWNERSHIP GIVEN
    dobj.printBase();
    //change base member values for member a
    bobj.setA(100);
    //dobj.setA(100);
    
    //demonstrate toString
    System.out.println(dobj.toString());
}
}