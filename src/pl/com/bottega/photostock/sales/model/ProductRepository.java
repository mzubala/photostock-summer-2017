package pl.com.bottega.photostock.sales.model;

import java.util.Optional;

public interface ProductRepository {

    // pobiera obiekt po identyfikatorze
    Product get(Long number);

    Optional<Product> getOptional(Long number);

    // zapis nowego lub aktualizacja istniejacego obiektu
    void save(Product product);

}
