package vendingSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount(){
        return this.drinks.size();
    }

    public void addDrink(Drink drink){
        if(this.drinks.size()<buttonCapacity){
            this.drinks.add(drink);
        }
    }

    public boolean removeDrink(String name){
        return drinks.removeIf(drink -> drink.getName().equals(name));
    }

    public Drink getLongest(){
        Drink curDrink = null;
        int maxVolume = Integer.MIN_VALUE;
        for (Drink drink : drinks) {
            if(drink.getVolume()>maxVolume){
                maxVolume = drink.getVolume();
                curDrink = drink;
            }
        }
        return curDrink;
    }

    public Drink getCheapest(){
        Drink curDrink = null;
        BigDecimal minPrice = new BigDecimal(Integer.MAX_VALUE);
        for (Drink drink : drinks) {
            int comp = drink.getPrice().compareTo(minPrice);
                if(comp<0){
                    minPrice = drink.getPrice();
                    curDrink = drink;

            }
        }
        return curDrink;
    }

    public String buyDrink(String name){
        Drink curDrink = null;
        for (Drink drink : drinks) {
            if(drink.getName().equals(name)){
                curDrink = drink;
            }
        }
        return curDrink.toString();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Drinks available:" + System.lineSeparator());
        for (Drink drink : drinks) {
            sb.append(drink + System.lineSeparator());
        }
        return sb.toString();
    }

}
