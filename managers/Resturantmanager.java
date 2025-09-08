package Tomato.managers;
import java.util.*;
import Tomato.models.*;
public class Resturantmanager {
    private List<Resturant>resturants=new ArrayList<>();
    private static Resturantmanager instance=null;
    private Resturantmanager(){}
    public static Resturantmanager getInstance(){
        if(instance==null){
            instance=new Resturantmanager();
        }
        return instance;
    }
    public void addResturant(Resturant r){
        resturants.add(r);
    }
    public List<Resturant> searchByLocation(String loc){
        List<Resturant>result=new ArrayList<>();
        loc=loc.toLowerCase();
        for(Resturant r:resturants){
            String rl=r.getLocation().toLowerCase();
            if(rl.equals(loc)){
                result.add(r);
            }
        }
        return result;
    }
}
