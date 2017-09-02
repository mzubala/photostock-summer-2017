package pl.com.bottega.photostock.sales.ui;

import pl.com.bottega.photostock.sales.infrastructure.InMemoryProductRepository;
import pl.com.bottega.photostock.sales.model.*;

public class ConsoleApp {

    public static void main(String[] args) {
        ProductRepository repository = new InMemoryProductRepository();
        Product p1 = repository.get(1L);
        Product p2 = repository.get(2L);
        Product p3 = repository.get(3L);

        Client client = new VIPClient("Jan Nowak", new Address("ul. Północna 11", "Poland", "Lublin", "20-001"));
        client.recharge(Money.valueOf(1000000));
        Reservation reservation = new Reservation(client);

        LightBox l = new LightBox(client, "kotki");
        l.add(p1);
        l.add(p2);
        l.add(p3);
        LightBoxPresenter presenter = new LightBoxPresenter();
        presenter.show(l);

        reservation.add(p1);
        reservation.add(p2);
        presenter.show(l);
        reservation.add(p3);

        System.out.println(String.format("W rezerwacji jest %d produktów", reservation.getItemsCount()));

        Offer offer = reservation.generateOffer();
        Money cost = offer.getTotalCost();
        if(client.canAfford(cost)) {
            Purchase purchase = new Purchase(client, offer.getItems());
            client.charge(cost, String.format("Zakup %s", purchase));
            System.out.println(String.format("Ilość zakupionych zdjęć: %d, całkowity koszt: %s", offer.getItemsCount(), offer.getTotalCost()));
        }
        else
            System.out.println("Sorry! Nie stać Cię ;p");


    }

}
