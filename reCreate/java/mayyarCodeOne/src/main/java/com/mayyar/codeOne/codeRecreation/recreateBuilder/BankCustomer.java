package com.mayyar.codeOne.codeRecreation.recreateBuilder;

/**
 * https://projectlombok.org/features/Builder
 */
public class BankCustomer {

    public static BankCustomerBuilder builder() {
        return new BankCustomerBuilder();
    }

    public static class BankCustomerBuilder {
        private BankCustomer bankCustomer;

        public BankCustomerBuilder() {
            this.bankCustomer = new BankCustomer();
        }

        public BankCustomerBuilder username(final String username) {
            bankCustomer.setUserName(username);
            return this;
        }

        public BankCustomerBuilder customerId(final String customerId) {
            bankCustomer.setCustomerId(customerId);
            return this;
        }

        public BankCustomerBuilder balance(final double balance) {
            bankCustomer.setBalance(balance);
            return this;
        }

        public BankCustomer build() {
            return this.bankCustomer;
        }

    }

    private String customerId;

    private double balance;

    private String username;

    public BankCustomer() {

    }

    public BankCustomer(final String customerId, final double balance, final String username) {
        this.customerId = customerId;
        this.balance = balance;
        this.username = username;
    }

    public void setUserName(final String username) {
        this.username = username;
    }

    public void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getUsername() {
        return this.username;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{").append("BankCustomer").append(":").append(" ");
        stringBuilder.append("{").append("customerId").append(":").append(" ").append(customerId).append("}");
        stringBuilder.append(" ").append(",");
        stringBuilder.append("{").append("username").append(":").append(" ").append(username).append("}");
        stringBuilder.append(" ").append(",");
        stringBuilder.append("{").append("balance").append(":").append(" ").append(balance).append("}");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}