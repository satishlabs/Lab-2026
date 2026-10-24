package com.meddium.sse.incedo24.strategypattern;

public class PayPalPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹"+ amount + " PayPal");
    }
}

/*
We'll create four parts:
1. PaymentStrategy — the common interface.
2. CardPayment, UpiPayment, and PayPalPayment — separate strategies.
3. CheckoutService — uses whichever strategy it receives.
4. Main — demonstrates switching strategies.

How does the code work?
- All payment classes implement the same PaymentStrategy interface.
- CheckoutService accepts a PaymentStrategy through its constructor.
- When checkout() is called, Java invokes the pay() implementation of the actual object.
- The checkout code doesn't need separate if-else blocks for Card, UPI, or PayPal.
* */
