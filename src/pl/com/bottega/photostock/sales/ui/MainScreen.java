package pl.com.bottega.photostock.sales.ui;

import java.util.Scanner;

public class MainScreen {

    private Scanner scanner;
    private LightBoxManagementScreen lightBoxManagementScreen;
    private SearchScreen searchScreen;

    public MainScreen(Scanner scanner, LightBoxManagementScreen lightBoxManagementScreen, SearchScreen searchScreen) {
        this.scanner = scanner;
        this.lightBoxManagementScreen = lightBoxManagementScreen;
        this.searchScreen = searchScreen;
    }

    public void show() {
        System.out.println("!!!Witamy w PHOTOSTOCK!!!");
        System.out.println("1. Wyszukaj produkty.");
        System.out.println("2. Lajt boksy.");
        System.out.print("Co chcesz zrobić? ");
    }

}
