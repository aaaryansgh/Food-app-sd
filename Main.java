package Tomato;
import java.util.List;

import Tomato.models.*;
import Tomato.strategies.*;
public class Main {
    public static void main(String[] args) {
        Tomato app=new Tomato();
        User user=new User(101,"Aryan","Delhi");
        System.out.println("User: "+user.getName()+ " is active.");
        List<Resturant> resturantList=app.searchResturants("Lonavla");
        if(resturantList.isEmpty()){
            System.out.println("No resturant found!");
            return;
        }
        System.out.println("Found resturants");
        for(Resturant res:resturantList){
            System.out.println(" - "+res.getName());
        }
        app.selectResturant(user,resturantList.get(0));
        System.out.println("Selected resturant: "+resturantList.get(0).getName());
        app.addToCart(user,"L1");
        app.addToCart(user,"L2");
        app.printUserCart(user);
        Order order=app.checkoutNow(user,"Delivery",new Upipayment("1234567890"));
        app.payForOrder(user, order);

    }
}
