package pl.ulman.sales;

import org.junit.Test;
import org.junit.Asserts;

class BasketTest {

    @Test
    public void itAllowsAddProductToBasket() {
        //Mam produkt lego-9293
        Product product1 = new Product("lego-9293");

        //Mam koszyk
        Basket basket = new Basket();

        //Do koszyka dodaj produkt "lego-9293"
        basket.add(product1);

        Assert.assertFalse(basket.isEmpty());
    }

    @Test
    public void itAllowsMultipleProducts(){
        Product product1 = new Product("lego-9293");
        Product product2 = new Product("lego-1311");
        Product product3 = new Product("lego-1378");
        Basket basket = new Basket();

        basket.add(product1);
        basket.add(product2);
        basket.add(product3);

        Assert.assertEquals(
                basket.productCount()
        );
    }

    @Test
    public void itAllowsMultipleProductsSameType(){
        Product product1 = new Product("lego-9293");

        Basket basket = new Basket();

        basket.add(product1);
        basket.add(product1);
        basket.add(product1);

        Assert.assertEquals(1, basket.productCount());
    }

    @Test
    public void itCouldBeEmpty() {
        Basket basket = new Basket();

        Assert.assertTrue(basket.isEmpty());
    }

}
