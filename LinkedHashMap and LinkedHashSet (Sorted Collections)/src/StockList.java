import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {
        //this.list = new HashMap<>();
        this.list = new LinkedHashMap<>(); // This has been changed later. (See comments in Main class from line 47).
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // check if already have quantities of this item.
            StockItem inStock = list.getOrDefault(item.getName(), item); // getOrDefault() method gets the item if it already exists in the Map and
                                                                         // if it doesn't exist its going to use this item that we are passing to this method.
                                                                         // So, at the end, inStock will have the item either retrieved from list or one that is passed.

            if (inStock != item) { // If there are already stocks on this item, adjust the quantity.
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();

            // So basically, in this method we are adding a new stock items to the list and updating them essentially if there it was
            // already a stocked item with that name.

            /*
            // We can also write above logic (from line 15 to 21) as:
            StockItem inStock = list.get(item.getName());
            if (inStock != null) {
                item.adjustStock(inStock.getQuantityStock());
            }
            */

        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null); // check if item name already exists, and if not then we define it to null.
        if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)) {
            inStock.adjustStock(-quantity); // deducting quantity.
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list); // Collections.unmodifiableMap() provides read only view of the Map, so we cannot modify it.
                                                  // BUT later on since we have changed HashMap to LinkedHashMap, there is no need to return
                                                  // unmodifiableMap because LinkedHashMap already stores items in a order we added them.
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) { // Iterating through entire Map.
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock(); // Getting total price of available no. of stocks of tha item.

            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: " + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + totalCost;
    }
}
