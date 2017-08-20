package pl.com.bottega.photostock.sales.model;

import java.sql.ClientInfoStatus;
import java.util.Collection;
import java.util.LinkedList;

public class LightBox {

    private String name;
    private Collection<Picture> items = new LinkedList<>();

    private Client owner;

    public LightBox(Client owner) {
        this.owner = owner;
    }

    public void add(Picture picture) {

    }

    public void remove(Picture picture) {

    }

}
