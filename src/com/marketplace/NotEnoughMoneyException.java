package com.marketplace;

public class NotEnoughMoneyException extends Exception{
    User user;
    NotEnoughMoneyException(User user){
        this.user = user;

    }
    @Override
    public String toString() {
        return "Exception!!! Looks like " + user + " does not have enough money!";
    }
}
