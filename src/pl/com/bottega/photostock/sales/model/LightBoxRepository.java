package pl.com.bottega.photostock.sales.model;

public interface LightBoxRepository {

    void save(LightBox lightBox);

    LightBox get(String number);

}
