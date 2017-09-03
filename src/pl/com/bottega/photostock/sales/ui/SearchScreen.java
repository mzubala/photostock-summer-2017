package pl.com.bottega.photostock.sales.ui;

import pl.com.bottega.photostock.sales.application.ProductCatalog;
import pl.com.bottega.photostock.sales.model.Money;
import pl.com.bottega.photostock.sales.model.Product;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SearchScreen {

    private Scanner scanner;
    private AuthenticationManager authenticationManager;
    private ProductCatalog productCatalog;

    public SearchScreen(Scanner scanner, AuthenticationManager authenticationManager, ProductCatalog productCatalog) {
        this.scanner = scanner;
        this.authenticationManager = authenticationManager;
        this.productCatalog = productCatalog;
    }

    public void show() {
        System.out.println("Podaj kryteria wyszukiwania");
        System.out.print("Tagi: ");
        Set<String> tags = getTags();
        System.out.print("Cena od: ");
        Money priceFrom = getMoney();
        System.out.println("Cena do: ");
        Money priceTo = getMoney();

        List<Product> productList = productCatalog.find(authenticationManager.getClient(), tags, priceFrom, priceTo);

        for (Product product : productList)
            showProduct(product);
    }

    private void showProduct(Product product) {

    }

    private Money getMoney() {
        return null;
    }

    public Set<String> getTags() {
        return null;
    }
}
