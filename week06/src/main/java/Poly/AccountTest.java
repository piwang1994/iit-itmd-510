package Poly;

public class AccountTest {
   
    public static void main(String args[]){
    //create objects
    Checking c = new Checking();
    Savings s = new Savings();
    
    Account aObjs [] = new Account[5];
    aObjs[0]= new Checking();
    aObjs[1]= new Checking();
    aObjs[2]= new Checking();
    aObjs[3]= new Savings();
    aObjs[4]= new Privilege();
    
    //test withdraw
    aObjs[0].withdraw(5);
    aObjs[4].withdraw(10);
        
    //System.out.println(c + "\n" + s );
    int checkCt=0 , savCt=0;
    for (Account a :  aObjs)
    {
         if(a.getName().equals("Checking"))
            checkCt++;
         if(a.getName().equals("Savings"))
            savCt++;
        System.out.println(a);
    }
        System.out.println("Tots: \n" +
                  "Checking ct: " + checkCt +
                  " Savings ct: " + savCt );
    }
}
