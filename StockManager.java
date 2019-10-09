import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Ben Adelson 
 * @version (10/09/2019)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Print details of all the products which has stock
     * levels below the given amount
     */
        public void printLowStockProducts(int upperLimit)
    {
        for(Product product : stock) {
            if(product.getQuantity() < upperLimit) {
                System.out.println(product.toString());
            }
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProduct(id);
        if(product != null) {
            product.increaseQuantity(amount);
        } 
    }

    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
{
        boolean found = false;
        int indexOfProduct= 0;
        while(indexOfProduct < stock.size() && !found){
                if(stock.get(indexOfProduct).getID() == id){
                    found = true;
                }else{
                    indexOfProduct++;
                }
        }
        if(found){
                return stock.get(indexOfProduct);
        }else{
                return null;
        }
}

public Product findProduct(String name)
    {
            boolean found = false;
            int indexOfProduct = 0;
            while(indexOfProduct < stock.size() && !found) {
                   if(stock.get(indexOfProduct).getName().equals(name)) {
                        found = true;
                    }else {
                        indexOfProduct++;
                    }
                }
            if(found) {
                    return stock.get(indexOfProduct);
            }else {
                   return null;
            }
    }

 
     /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product product = findProduct(id);
        if(product != null) {
            return product.getQuantity();
        }else {
            return 0;
        }
    }
    
    /**
     * Add a product to the list, if there is not already one with a similar copy
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
       //if(findProduct(item.getID() == id)){
            stock.add(item);
      //  }

    }

    
    // old version
    
    // public void addProduct(Product item)
    // {
        // stock.add(item);
    // }
    


    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product product:stock){
            System.out.println(product.toString());
        }
    }
}
