package pl.com.bottega.photostock.sales.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LightBox {

    private String name;
    private List<Product> items = new LinkedList<>();

    private Client owner;

    public LightBox(Client owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public void add(Product product) {
        if(items.contains(product))
            throw new IllegalStateException("Product already added");
        if(!product.isAvailable())
            throw new IllegalArgumentException("Product is not available");
        items.add(product);
    }

    public void remove(Product product) {
        if(!items.remove(product))
            throw new IllegalArgumentException("Product not added to lightbox");
    }

    public String getName() {
        return name;
    }

    public Client getOwner() {
        return owner;
    }

    public List<Product> getItems() {
        return Collections.unmodifiableList(items);
    }
}
