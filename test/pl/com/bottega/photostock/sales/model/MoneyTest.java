package pl.com.bottega.photostock.sales.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyTest {

    private Money fiftyCredit = Money.valueOf(50);
    private Money seventyCredit = Money.valueOf(70);
    private Money fiftyEur = Money.valueOf(50, "EUR");

    @Test
    public void shouldAddMoney() {
        // when
        Money sum = fiftyCredit.add(seventyCredit);

        // then
        Money expected = Money.valueOf(120);
        assertEquals(expected, sum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddMoneyInDifferentCurrencies() {
        // when
        fiftyEur.add(seventyCredit);
    }

    @Test
    public void shouldSubtractMoney() {
        // when
        Money dif = fiftyCredit.sub(seventyCredit);

        // then
        Money expected = Money.valueOf(-20);
        assertEquals(expected, dif);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotSubtractMoneyInDifferentCurrencies() {
        // when
        fiftyEur.sub(seventyCredit);
    }

}
