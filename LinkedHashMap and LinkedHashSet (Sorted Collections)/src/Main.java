import java.util.Map;

public class Main {


    // LinkedHashMap and LinkedHashSet are the Linked variants of HashMaps and HashSets respectively.
    // And the difference is that these has ordering to them.
    // So the order in which we put the elements in the LinkedHashMap or LinkedHashSet, they will come back in the same
    // order when we iterate over it.

    // In this example, we are going to see LinkedHashMap.

    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        // After printing, we can see that stockItems list displayed are in the random manner and not in the sequence that
        // we added items above. This is because we are using the HashMap in the StockList class for storing items.
        // So now we will use LinkedHashMap instead of HashMap.

        // After changing HashMap to LinkedHashMap (in StockList class on line 12), now we can see that items are displayed
        // in the same order as we added them.

        // Below code is for checking selling items.
        Basket timsBasket = new Basket("Tim");

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1); // It should give error to this because we have only 2 quantities of car and we have sold that already above.
        sellItem(timsBasket, "spanner", 5); // This should also give error because we don't have spanner as item.
        System.out.println(timsBasket);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);
        System.out.println(timsBasket);

        System.out.println(stockList);

        ////////////////// TreeMap ///////////////////
        // Still after this as we are printing the basket(timsBasket), the items appear in random order.
        // So in Basket class we need to change HashMap to TreeMap.

        // Now after adding TreeMap, we can see that our shopping basket is displayed in alphabetical order.
        // TreeMap is sorting it by using compareTo method that we implemented in StockItem class.


        //temp = new StockItem("pen", 1.12);
        //stockList.Items().put(temp.getName(), temp); // This will give error because Items() returns unmodifiableMao list.

        // But we can modify by accessing the specific item like:
        stockList.Items().get("car").adjustStock(2000);
        stockList.get("car").adjustStock(-1000); // We can also do by directly using get() method.
        System.out.println(stockList); // As we can see in output that we have modified car quantities to 2000.

        // So we can conclude that only Collection is unmodifiable but the objects within it are not.

        // printing prices for each item.
        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item); // retrieving the item from stockList.
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0; // returning the quantity sold.
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
