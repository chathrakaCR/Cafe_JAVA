// Shakes Class
public class Shake extends FoodItem{
    public Shake (double price){
        super("Shake", price);
    }

    @Override
    public boolean order(int qty) {
        totSold += qty;  // unlimited, just count sales
        return true;
    }
}
