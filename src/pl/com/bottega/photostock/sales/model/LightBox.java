package pl.com.bottega.photostock.sales.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class LightBox {

    private String name;
    private List<Picture> items = new LinkedList<>();

    private Client owner;
    private String number;

    public LightBox(Client owner, String name) {
        this.owner = owner;
        this.name = name;
        this.number = UUID.randomUUID().toString();
    }

    public void add(Picture pciture) {
        if(items.contains(pciture))
            throw new IllegalStateException("Product already added");
        pciture.ensureAvailable();
        items.add(pciture);
    }

    public void remove(Picture picture) {
        if(!items.remove(picture))
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

    public String getNumber() {
        return number;
    }

}
