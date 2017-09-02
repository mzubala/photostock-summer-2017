package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.Client;
import pl.com.bottega.photostock.sales.model.ClientRepository;
import pl.com.bottega.photostock.sales.model.Reservation;
import pl.com.bottega.photostock.sales.model.ReservationRepository;

public class PurchaseProcess {

    private ClientRepository clientRepository;
    private ReservationRepository reservationRepository;

    public PurchaseProcess(ClientRepository repository, ReservationRepository reservationRepository) {
        this.clientRepository = repository;
    }

    public String createReservation(Long clientNumber) {
        Client client = clientRepository.get(clientNumber);
        Reservation reservation = new Reservation(client);
        reservationRepository.save(reservation);
        return reservation.getNumber();
    }

}
