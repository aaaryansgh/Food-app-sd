package Tomato.strategies;

public class Card implements Paymentstrategy{
    private String cardNumber;
    public Card(String cardNumber){
        this.cardNumber=cardNumber;
    }
    @Override
    public void pay(double amount){
        System.out.println("paid Rs."+amount+" using Card number: "+cardNumber);
    }
}
