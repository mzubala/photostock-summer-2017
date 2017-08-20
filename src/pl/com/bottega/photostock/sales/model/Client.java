package pl.com.bottega.photostock.sales.model;

public class Client {

    private String name;
    private Address address;
    private ClientStatus status;
    private Money balance;
    private Money creditLimit;

    public Client(String name, Address address, ClientStatus status, Money balance, Money creditLimit) {
        this.name = name;
        this.address = address;
        this.status = status;
        this.balance = balance;
        this.creditLimit = creditLimit;
    }

    public Client(String name, Address address) {
        this(name, address, ClientStatus.STANDARD, Money.ZERO, Money.ZERO);
    }

    public boolean canAfford(Money money) {
        return false;
    }

    public void charge(Money amount, String reason) {

    }

    public void recharge(Money amount) {

    }

}
