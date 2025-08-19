// Coffee Class
public class Coffee extends FoodItem{
    public Coffee(double price){
        super("Shake", price);
    }

    @Override
    public boolean order(int qty) {
        totSold += qty;
        return true;
    }
}
