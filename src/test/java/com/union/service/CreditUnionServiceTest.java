package com.union.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.union.exception.DMICreditServiceException;
import com.union.model.Account;
import com.union.model.Individual;
import com.union.model.MoneyMarket;

public class CreditUnionServiceTest {
    AccountService service;

    @Before
    public void init() {
        service = new AccountServiceImpl();
    }

    @After
    public void close() {
        service = null;
    }

    @Test
    public void test_withdraw() {
        Account moneyMarket = new MoneyMarket("mny", 2000d);
        Account individual = new Individual("ind", 1000d);

        service.withdraw(moneyMarket, 500d);
        Assert.assertEquals(1500d, moneyMarket.getBalance(), 0.001);

        service.withdraw(individual, 100d);
        Assert.assertEquals(900d, individual.getBalance(), 0.001);
    }

    @Test
    public void test_deposit() {
        Account moneyMarket = new MoneyMarket("mny", 1000d);

        service.deposit(moneyMarket, 500d);
        Assert.assertEquals(1500d, moneyMarket.getBalance(), 0.001);
    }

    @Test
    public void test_transfer() {
        Account moneyMarket = new MoneyMarket("mny", 1000d);
        Account individual = new Individual("ind", 2000d);

        service.transfer(moneyMarket, individual, 200d);
        Assert.assertEquals(800d, moneyMarket.getBalance(), 0.001);
        Assert.assertEquals(2200d, individual.getBalance(), 0.001);
    }

    @Test(expected = DMICreditServiceException.class)
    public void test_withdraw_for_limit_exceeded() {
        Account individual = new Individual("ind", 1000d);

        service.withdraw(individual, 300d);
    }
}