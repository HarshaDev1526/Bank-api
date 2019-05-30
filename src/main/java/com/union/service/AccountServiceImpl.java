package com.union.service;

import com.union.exception.DMICreditServiceException;
import com.union.model.Account;
import com.union.model.Individual;

public class AccountServiceImpl implements AccountService {
    private static final double WITHDRAW_LIMIT = 250;

    @Override
    public void deposit(Account account, double value) {
        validateAmount(value);
        account.setBalance(account.getBalance() + value);
    }

    @Override
    public void withdraw(Account account, double value) {
        if (account instanceof Individual) {
            if (value > WITHDRAW_LIMIT) {
                throw new DMICreditServiceException("WITHDRAW_LIMIT exceeded");
            }
        }

        double balance = account.getBalance() - value;
        validateAmount(balance);
        account.setBalance(balance);
    }

    @Override
    public void transfer(Account src, Account dst, double value) {
        validateAmount(value);
        if (src instanceof Individual) {
            if (value > WITHDRAW_LIMIT) {
                throw new DMICreditServiceException("WITHDRAW_LIMIT exceeded");
            }
        }
        double balance = src.getBalance() - value;
        validateAmount(balance);

        src.setBalance(balance);
        dst.setBalance(dst.getBalance() + value);
    }

    private void validateAmount(double amount) {
        if (amount < 0) {
            throw new DMICreditServiceException("Amount cannot be negative");
        }
    }
}