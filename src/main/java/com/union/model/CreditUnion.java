package com.union.model;

import java.util.ArrayList;
import java.util.List;

public class CreditUnion {
    private String name;
    private List<Account> accounts = new ArrayList<>();

    public CreditUnion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}