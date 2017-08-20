package pl.com.bottega.photostock.sales.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void shouldCompareMoney() {
        assertTrue(fiftyCredit.compareTo(seventyCredit) < 0);
        assertTrue(seventyCredit.compareTo(fiftyCredit) > 0);
        assertTrue(fiftyCredit.compareTo(fiftyCredit) == 0);
    }

    @Test
    public void shouldCompareMoneyUsingBooleanMethods() {
        assertTrue(fiftyCredit.lt(seventyCredit));
        assertTrue(fiftyCredit.lte(seventyCredit));
        assertTrue(seventyCredit.gt(fiftyCredit));
        assertTrue(seventyCredit.gte(fiftyCredit));
        assertFalse(fiftyCredit.gt(seventyCredit));
        assertFalse(fiftyCredit.gte(seventyCredit));
        assertFalse(seventyCredit.lt(fiftyCredit));
        assertFalse(seventyCredit.lte(fiftyCredit));
        assertTrue(fiftyCredit.gte(fiftyCredit));
        assertTrue(fiftyCredit.lte(fiftyCredit));
        assertFalse(fiftyCredit.lt(fiftyCredit));
        assertFalse(fiftyCredit.gt(fiftyCredit));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCompareDifferentCurrencies() {
        fiftyCredit.compareTo(fiftyEur);
    }

}
