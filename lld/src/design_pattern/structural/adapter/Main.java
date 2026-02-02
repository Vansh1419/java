package design_pattern.structural.adapter;

import java.util.concurrent.Callable;

interface PaymentGateway{
    void pay(String orderId, double amount);
}

class PayUGateway implements PaymentGateway{
    @Override
    public void pay(String orderId, double amount) {
        System.out.println("Paid rs" + amount + "using PayU for orderId" + orderId);
    }
}

class CheckoutService {
    private PaymentGateway paymentGateway;

    // Constructor injection for dependency inversion
    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    // Business logic to perform checkout
    public void checkout(String orderId, double amount) {
        paymentGateway.pay(orderId, amount);
    }
}

// Payment gateway with diff interface
class RazorpayApi{
    public void makePayment(String invoiceId, double amountInRs){
        System.out.println("Paid Rs. " + amountInRs + " using Razorpay for invoice: " + invoiceId);
    }
}

// Adding adapter to incompatibility

class RazorpayAdapter implements PaymentGateway{
    private RazorpayApi razorpayApi;

    public RazorpayAdapter() {
        this.razorpayApi = new RazorpayApi();
    }

    @Override
    public void pay(String orderId, double amount) {
        razorpayApi.makePayment(orderId,amount);
    }
}

public class Main {
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService(new PayUGateway());
        checkoutService.checkout("12",178);

        CheckoutService checkoutService2 = new CheckoutService(new RazorpayAdapter());
        checkoutService2.checkout("10",174);
    }
}
