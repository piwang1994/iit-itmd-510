 class Order {

    private int orderNum;
    private double orderAmount;
    private double orderDiscount;
//    public abstract name1();
    public Order(int orderNumber, double orderAmt, double orderDisc)  {

        orderNum = orderNumber;
        orderAmount = orderAmt;
        orderDiscount = orderDisc;
    }
    public double finalOrderTotal( )  {

        return orderAmount - orderAmount * orderDiscount;

    }
}
public class CustomerOrder  {

    public static void main(String[ ] args) {
        Order order;
        int orderNumber = 1234;
        double orderAmt = 580.00;
        double orderDisc = .1;
        order = new Order(orderNumber, orderAmt, orderDisc);
        double finalAmount = order.finalOrderTotal( );
        System.out.println("Final order amount = $" + finalAmount);
    }
}