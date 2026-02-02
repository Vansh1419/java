package design_pattern.creational.abstractFactory;

import javax.swing.plaf.synth.Region;

interface PaymentGateway{
    void processPayment(double amount);
}

class RazorPayment implements PaymentGateway{
    @Override
    public void processPayment(double amount) {
        System.out.println("Razor payment for "+amount);
    }
}
class UpiPayment implements PaymentGateway{
    @Override
    public void processPayment(double amount) {
        System.out.println("UPI payment for "+amount);
    }
}

class PaypalPayment implements PaymentGateway{
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal payment for "+amount);
    }
}
class StripePayment implements PaymentGateway{
    @Override
    public void processPayment(double amount) {
        System.out.println("Stripe payment for "+amount);
    }
}


interface Invoice{
    void generateInvoice();
}

class GSTInvoice implements Invoice{
    @Override
    public void generateInvoice() {
        System.out.println("GST invoice for GST");
    }
}
class USInvoice implements Invoice{
    @Override
    public void generateInvoice() {
        System.out.println("US invoice for US");
    }
}

// Here I have violated srp principle
/*
class CheckoutService{
    private String gatewayType;

    public CheckoutService(String gatewayType) {
        this.gatewayType = gatewayType;
    }

    public void checkout(double amount){
        if(gatewayType.equals("razorpay")){
            PaymentGateway paymentGateway = new RazorPayment();
            paymentGateway.processPayment(amount);
        }
        else if(gatewayType.equals("upi")){
            PaymentGateway paymentGateway = new UpiPayment();
            paymentGateway.processPayment(amount);
        }
        Invoice gstInvoice = new GSTInvoice();
        gstInvoice.generateInvoice();
    }
}
 */

interface RegionFactory{
    PaymentGateway createGateway(String gatewayType);
    Invoice createInvoice();
}

class IndiaFactory implements RegionFactory{
    public PaymentGateway createGateway(String gatewayType){
        if(gatewayType.equals("razorpay")){
            return new RazorPayment();
        }
        return new UpiPayment();
    }

    public Invoice createInvoice(){
        return new GSTInvoice();
    }
}

class USFactory implements RegionFactory{
    public PaymentGateway createGateway(String gatewayType){
        if(gatewayType.equals("paypal")){
            return new PaypalPayment();
        }
        return new StripePayment();
    }

    public Invoice createInvoice(){
        return new USInvoice();
    }
}


class CheckoutService{
    private PaymentGateway paymentGateway;
    private Invoice invoice;
    private String gatewayType;

    public CheckoutService(RegionFactory regionFactory, String gatewayType) {
        this.gatewayType = gatewayType;
        this.paymentGateway = regionFactory.createGateway(this.gatewayType);
        this.invoice = regionFactory.createInvoice();
    }

    public void completeOrder(double amount){
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}

public class Main {
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService(new IndiaFactory(),"razorpay");
        checkoutService.completeOrder(10000);
        CheckoutService checkoutServiceUs = new CheckoutService(new USFactory(),"paypal");
        checkoutServiceUs.completeOrder(1000);
    }
}
