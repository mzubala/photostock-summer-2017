package pl.com.bottega.photostock.sales.model.repositories;

import pl.com.bottega.photostock.sales.model.LightBox;

public interface LightBoxRepository {

    void save(LightBox lightBox);

    LightBox get(String number);

}
