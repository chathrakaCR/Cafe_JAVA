// Combo food Items Class
public class Combo {
    private FoodItem drink;
    private Muffin muffin;

    public Combo(FoodItem drink, Muffin muffin){
        this.drink = drink;
        this.muffin = muffin;
    }

    public double getComboPrice(){
        return(drink.getPrice() + muffin.getPrice()) - 1.0;
    }

    public boolean order() {
        if (muffin.getStock() > 0) {
            muffin.order(1);
            drink.order(1);
            return true;
        }
        return false;
    }

    public String getName() {
        return drink.getName() + " + Muffin Combo";
    }
}
