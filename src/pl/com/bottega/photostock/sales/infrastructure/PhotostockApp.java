package pl.com.bottega.photostock.sales.infrastructure;

import pl.com.bottega.photostock.sales.application.LightBoxManagement;
import pl.com.bottega.photostock.sales.application.ProductCatalog;
import pl.com.bottega.photostock.sales.infrastructure.repositories.InMemoryClientRepository;
import pl.com.bottega.photostock.sales.infrastructure.repositories.InMemoryLightBoxRepository;
import pl.com.bottega.photostock.sales.infrastructure.repositories.InMemoryProductRepository;
import pl.com.bottega.photostock.sales.infrastructure.repositories.InMemoryReservationRepository;
import pl.com.bottega.photostock.sales.model.repositories.ClientRepository;
import pl.com.bottega.photostock.sales.model.repositories.LightBoxRepository;
import pl.com.bottega.photostock.sales.model.repositories.ProductRepository;
import pl.com.bottega.photostock.sales.model.repositories.ReservationRepository;
import pl.com.bottega.photostock.sales.ui.AuthenticationManager;
import pl.com.bottega.photostock.sales.ui.LightBoxManagementScreen;
import pl.com.bottega.photostock.sales.ui.MainScreen;
import pl.com.bottega.photostock.sales.ui.SearchScreen;

import java.util.Scanner;

public class PhotostockApp {

    public static void main(String[] args) {
        new PhotostockApp().start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        LightBoxRepository lightBoxRepository = new InMemoryLightBoxRepository();
        ClientRepository clientRepository = new InMemoryClientRepository();
        ProductRepository productRepository = new InMemoryProductRepository();
        ReservationRepository reservationRepository = new InMemoryReservationRepository();
        LightBoxManagement lightBoxManagement = new LightBoxManagement(lightBoxRepository, clientRepository,
                productRepository, reservationRepository);
        LightBoxManagementScreen lightBoxManagementScreen = new LightBoxManagementScreen(scanner, lightBoxManagement);
        ProductCatalog productCatalog = new ProductCatalog(productRepository);
        AuthenticationManager authenticationManager = new AuthenticationManager();
        SearchScreen searchScreen = new SearchScreen(scanner, authenticationManager, productCatalog);
        MainScreen mainScreen = new MainScreen(scanner, lightBoxManagementScreen, searchScreen);

        mainScreen.show();
    }

}
