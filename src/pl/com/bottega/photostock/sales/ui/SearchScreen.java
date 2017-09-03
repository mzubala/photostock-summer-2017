package pl.com.bottega.photostock.sales.ui;

import pl.com.bottega.photostock.sales.application.ProductCatalog;

import java.util.Scanner;

public class SearchScreen {

    private Scanner scanner;
    private ProductCatalog productCatalog;

    public SearchScreen(Scanner scanner, ProductCatalog productCatalog) {
        this.scanner = scanner;
        this.productCatalog = productCatalog;
    }

}
