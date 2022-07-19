class Father{
//    public Father(int arg){
//        System.out.println(arg);
//    }
}

public class TestArgs extends Father{
    public TestArgs() {
//        super();
//        this.setSize(200,200);
//        this.setVisible(true);
    }

    public TestArgs(int arg) {
//        super();
        System.out.println(arg);
//        this.setSize(200,200);
//        this.setVisible(true);
    }
    public void test(){
        System.out.println(2);
    }

    public static void main(String[] args) {
        Father cFrame = new TestArgs(1);
        ((TestArgs)cFrame).test();
    }
}