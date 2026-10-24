package com.meddium.sse.incedo24.strategypattern;

public class CheckoutService {
    private final PaymentStrategy paymentStrategy;

    public CheckoutService(PaymentStrategy strategy){
        this.paymentStrategy = strategy;
    }

    public void checkout(double amount){
        paymentStrategy.pay(amount);
    }
}
