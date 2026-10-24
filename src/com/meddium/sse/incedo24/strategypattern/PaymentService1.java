package com.meddium.sse.incedo24.strategypattern;

public class PaymentService1 {
    public  void pay(String type, double amount){
        if(type.equals("CARD")){
            System.out.println("Processing card payment: "+amount);
        }else if(type.equals("UPI")){
            System.out.println("Processing UPI payment: "+amount);
        }else if(type.equals("PAYPAL")){
            System.out.println("Processing PayPal payment: "+ amount);
        }else{
            throw new IllegalArgumentException("Unsupported payment type");
        }
    }
}
