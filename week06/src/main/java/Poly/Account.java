package Poly;

public class Account {

    protected String name;
    protected double balance;

    
    public Account(String name) {
   
        this.name = name;
      
    }
    public void deposit(double amount){
    this.balance += amount;
    }
    public void withdraw(double amount){
    this.balance  =  (balance-amount) < 0 ? 0 : (balance-amount);
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public String getName() { return name; }
    
    @Override
    public String toString(){
      
        return name + " " + "balance is " + balance ;
    }
}
 
