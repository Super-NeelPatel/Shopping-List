public class Item {
    String itemName;
    int itemQuantity;
    double itemPrice;

    public Item(String name, int itemQuantity, double price){
        this.itemName = name;
        this.itemQuantity = itemQuantity;
        this.itemPrice = price;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
