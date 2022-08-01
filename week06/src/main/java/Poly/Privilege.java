package Poly;

public class Privilege extends Account{
    
    
    public Privilege () {
        super("Privilege");
        
    }
    //override the parent
    public void withdraw(double amount) {
        
        this.balance -= amount;
    }
    
}
