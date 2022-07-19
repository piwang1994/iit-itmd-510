public class AccountHolder {

    /*
    The AccountHolder file must include the following class field members and data methods to allow for transaction processing.
     */
    static double annualInterestRate;
    private double balance;
    /*
     Constructor to accept an argument representing an initial balance for the Account holder. Set your balance member
     equal to the value passed via the class constructor.
     Balances cannot start off negative! Include an error message if this is the situation.
     */
    public AccountHolder(double balance) {
        if(balance < 0)throw new IllegalArgumentException("init balance can't be negative");
        this.balance = balance;
    }

    public void deposit(double amt) {
        this.balance += amt;

    }

    public void withdrawal(double amt) {
        this.balance -= amt;

    }
//    monthlyInterest method body an assignment statement to update the account holders’ balance
    public void monthlyInterest() {
        this.balance += this.balance * (annualInterestRate / 12.0);
    }

    public double getBalance(){
        return this.balance;
    }
}
