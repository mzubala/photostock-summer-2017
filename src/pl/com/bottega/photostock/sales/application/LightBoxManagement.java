package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.Client;
import pl.com.bottega.photostock.sales.model.ClientRepository;
import pl.com.bottega.photostock.sales.model.LightBox;
import pl.com.bottega.photostock.sales.model.LightBoxRepository;

public class LightBoxManagement {

    private LightBoxRepository lightBoxRepository;
    private ClientRepository clientRepository;

    public LightBoxManagement(LightBoxRepository lightBoxRepository, ClientRepository clientRepository) {
        this.lightBoxRepository = lightBoxRepository;
        this.clientRepository = clientRepository;
    }

    public String create(String clientNumber, String lightBoxName) {
        Client client = clientRepository.get(clientNumber);
        LightBox lbox = new LightBox(client, lightBoxName);
        lightBoxRepository.save(lbox);
        return lbox.getNumber();
    }

}
