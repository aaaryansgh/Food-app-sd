package Tomato.strategies;
public class Upipayment implements Paymentstrategy{
    private String mobNumber;
    public Upipayment(String mobNumber){
        this.mobNumber=mobNumber;
    }
    @Override
    public void pay(double amount){
        System.out.println("paid Rs."+amount+" using UPI payment from mobile number: "+mobNumber);
    }
}

