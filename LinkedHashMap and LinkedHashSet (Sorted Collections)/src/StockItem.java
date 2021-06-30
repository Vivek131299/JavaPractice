public class StockItem implements Comparable<StockItem> { // Implementing Comparable so that stock items can be used in a sorted collections.

    private final String name;
    private double price;
    private int quantityStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    // Overloading constructor so that the items can be created with or without stock levels.
    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if (obj == this) { // To see whether we actually testing against the same object in memory.
            return true;
        }

        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName(); // Equals is just going to use the name, So getting the name of current object.
        return this.name.equals(objName); // Also checking the name of current object and name in memory.
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31; // returning String hashCode, also adding any arbitrary number to it(we used 31 here).
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if (this == o) {
            return 0;
        }

        if (o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException(); // Throw exception if we got null.
    }

    @Override
    public String toString() {
        return this.name + " : price - " + this.price;
    }
}
