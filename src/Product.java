package pl.ulman.sales;

class Product {
    private String name;
    private final Integer stockQuantity;

    public Product(String name) {
        this.name = name;
        this.stockQuantity = 0;
    }

    public Product(String name, Integer stockQty) {
        this.name = name;
        this.stockQuantity = stockQty;
    }

    public boolean isInStock(){
        return stockQuantity > 0;
    }

    public String getName(){ return name; }
}
