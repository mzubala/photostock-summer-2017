package pl.com.bottega.photostock.sales.model;

import java.util.HashSet;
import java.util.Set;

public class Picture {

    private Long number;
    private Set<String> tags;
    private Money price;
    private Boolean active;

    public Picture(Long number, Set<String> tags, Money price) {
        this(number, tags, price, true);
    }

    public Picture(Long number, Set<String> tags, Money price, Boolean active) {
        this.number = number;
        this.tags = new HashSet<>(tags);
        this.price = price;
        this.active = active;
        Class c = Purchase.class;
    }

    public Money calculatePrice(Client client) {
        return null;
    }

    public boolean isAvailable() {
        return false;
    }

    public void reservedPer(Client client) {

    }

    public void unreservedPer(Client client) {

    }

    public void soldPer(Client client) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picture picture = (Picture) o;

        return number.equals(picture.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

}
