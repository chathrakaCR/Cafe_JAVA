// Muffins Class
public class Muffin extends  FoodItem{
    private int stock;

    public Muffin(double price, int stock){
        super("Muffin", price);
        this.stock = stock;
    }

    @Override
    public boolean order(int qty) {
        if (qty <= stock) {
            stock -= qty;
            totSold += qty;
            return true;
        }
        return false;
    }

    public int getStock() { return stock; }

    public void addStock(int qty){
        stock += qty;
    }
}
