package pl.com.bottega.photostock.sales.model;

import com.sun.deploy.util.SessionState;

import java.util.*;

public class Offer {

    private Client owner;
    private List<Picture> items;

    public Offer(Client owner, Collection<Picture> items) {
        this.owner = owner;
        this.items = new LinkedList<>(items);
        this.items.sort(new Comparator<Picture>() {
            @Override
            public int compare(Picture o1, Picture o2) {
                return o2.calculatePrice(owner).compareTo(o1.calculatePrice(owner));
            }
        });
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
