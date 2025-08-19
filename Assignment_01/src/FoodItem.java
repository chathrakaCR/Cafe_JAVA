// Abstract Class for Food Items
public abstract class FoodItem {
    protected String name;
    protected double price;
    protected int totSold;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.totSold = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getTotSold() {
        return totSold;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract boolean order(int qty);

    public double getTotSales(){
        return totSold*price;
    }

}

