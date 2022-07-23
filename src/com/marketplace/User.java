package com.marketplace;

import java.util.Objects;

public class User {
    static int counter;
    private final int id;
    private String firstName;
    private String lastName;
    private double amountOfMoney;

    public User(String firstName, String lastName, double amountOfMoney) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    public int getId() {
        return this.id;
    }

    public void setFirstName(String firstName) {
        if(!firstName.isEmpty()) {
            this.firstName = firstName;
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        if(!lastName.isEmpty()) {
            this.firstName = lastName;
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public double getAmountOfMoney() {
        return this.amountOfMoney;
    }

    public void withdrawals(double sum) throws NotEnoughMoneyException{
        if(this.amountOfMoney >= sum) {
            this.amountOfMoney -= sum;
        } else {
            throw new NotEnoughMoneyException(this);
        }
    }

    @Override
    public String toString() {
        return "User {Id: " + id + "; First name: " + firstName + "; Last name: " + lastName + "; Amount of money: " + amountOfMoney + "$}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Double.compare(user.amountOfMoney, amountOfMoney) == 0 && firstName.equals(user.firstName) && lastName.equals(user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, amountOfMoney);
    }
}
