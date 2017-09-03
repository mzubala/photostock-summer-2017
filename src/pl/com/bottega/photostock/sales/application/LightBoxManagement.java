package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.*;

public class LightBoxManagement {

    private LightBoxRepository lightBoxRepository;
    private ClientRepository clientRepository;
    private ProductRepository productRepository;

    public LightBoxManagement(LightBoxRepository lightBoxRepository, ClientRepository clientRepository, ProductRepository productRepository) {
        this.lightBoxRepository = lightBoxRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    public String create(String clientNumber, String lightBoxName) {
        Client client = clientRepository.get(clientNumber);
        LightBox lbox = new LightBox(client, lightBoxName);
        lightBoxRepository.save(lbox);
        return lbox.getNumber();
    }

    public void add(String lightBoxNumber, Long productNumber) {
        Product product = productRepository.get(productNumber);
        if(!(product instanceof Picture))
            throw new IllegalArgumentException("Can only add pictures to repository");
        LightBox lightBox = lightBoxRepository.get(lightBoxNumber);
        Picture picture = (Picture) product;
        lightBox.add(picture);
        lightBoxRepository.save(lightBox);
    }

}
