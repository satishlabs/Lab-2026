package com.meddium.sse.incedo24.strategypattern;

public class MainStrategy {
    public static void main(String[] args) {
        CheckoutService cardCheckout = new CheckoutService(new CardPayment());
        cardCheckout.checkout(1500);

        CheckoutService upiCheckout = new CheckoutService(new UpiPayment());
        upiCheckout.checkout(800);

        CheckoutService payPalCheckout = new CheckoutService(new PayPalPayment());
        payPalCheckout.checkout(2000);
    }
}
