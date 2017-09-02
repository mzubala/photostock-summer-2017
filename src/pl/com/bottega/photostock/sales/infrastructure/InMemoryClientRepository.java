package pl.com.bottega.photostock.sales.infrastructure;

import pl.com.bottega.photostock.sales.model.Client;
import pl.com.bottega.photostock.sales.model.ClientRepository;

public class InMemoryClientRepository implements ClientRepository {
    @Override
    public Client get(Long number) {
        return null;
    }
}
