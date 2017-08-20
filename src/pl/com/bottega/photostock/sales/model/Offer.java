package pl.com.bottega.photostock.sales.model;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Offer {

    private Client owner;
    private Collection<Picture> items;

    public Offer(Client owner, Collection<Picture> items) {
        this.owner = owner;
        this.items = new LinkedList<>(items);
    }

    public boolean sameAs(Offer offer, Money tolerance) {
        return false;
    }

    public int getItemsCount() {
        return items.size();
    }

    public Money getTotalCost() {
        Money total = Money.ZERO;
        for (Picture item : items)
            total = total.add(item.calculatePrice(owner));
        return total;
    }

    public Collection<Picture> getItems() {
        return Collections.unmodifiableCollection(items);
    }

}
