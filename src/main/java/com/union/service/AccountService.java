package com.union.service;

import com.union.model.Account;

public interface AccountService {
    void withdraw(Account acc, double value);

    void deposit(Account acc, double value);

    void transfer(Account acc, Account toAcc, double value);
}