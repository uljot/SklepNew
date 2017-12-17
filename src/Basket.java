package pl.ulman.sales;

import java.util.*;

class Basket {

	private final HashMap<pl.ulman.sales.Product,  Integer> productsQuantities;

    public Basket() {
        this.productsQuantities = new HashMap<pl.ulman.sales.Product, Integer>();
    }

    public void add(pl.ulman.sales.Product product){

        if(!product.isInStock()){
            throw new pl.ulman.sales.ProductNotAvailableException();
        }

        if(!isInBasket(product)){
            putToBasket(product);
        } else {
            increaseQuantity(product);
        }
    }

    public boolean isEmpty(){ return productsQuantities.size() == 0; }

    public int productCount(){
        return productsQuantities.size();
    }

    private void putToBasket(pl.ulman.sales.Product product){ productsQuantities.put(product, 1); }

    private void increaseQuantity(pl.ulman.sales.Product product) { productsQuantities.put(product, productsQuantities.get(product) +1); }

    private boolean isInBasket(pl.ulman.sales.Product product) { return productsQuantities.containsKey(product); }

    public List<pl.ulman.sales.BasketItem> getItemsInBasket(){
        ArrayList<pl.ulman.sales.BasketItem> items = new ArrayList<pl.ulman.sales.BasketItem>(productsQuantities.size());

        productsQuantities.forEach((product, quantity) -> items.add(new pl.ulman.sales.BasketItem(product.getName(), quantity)));

        return Collections.unmodifiableList(items);
    }
}
