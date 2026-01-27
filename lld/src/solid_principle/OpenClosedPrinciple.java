package solid_principle;

public class OpenClosedPrinciple {
    // Tax strategy Interface
    interface TaxCalculator {
        double calculateTax(double amount);
    }

    // Implementing Region-Specific Tax Calculators
    static class IndiaTaxCalculator implements TaxCalculator {
        public double calculateTax(double amount) {
            return amount * 0.18; // GST
        }
    }
    static class USTaxCalculator implements TaxCalculator {
        public double calculateTax(double amount) {
            return amount * 0.08; // Sales Tax
        }
    }
    static class UKTaxCalculator implements TaxCalculator {
        public double calculateTax(double amount) {
            return amount * 0.12; // VAT
        }
    }

    // Using dependency Injection
    static class Invoice {
        private double amount;
        private TaxCalculator taxCalculator;

        public Invoice(double amount, TaxCalculator taxCalculator) {
            this.amount = amount;
            this.taxCalculator = taxCalculator;
        }

        public double getTotalAmount() {
            return amount + taxCalculator.calculateTax(amount);
        }
    }

    // Main class
    static class Main {
        public static void main(String[] args) {
            double amount = 1000.0;

            Invoice indiaInvoice = new Invoice(amount, new IndiaTaxCalculator());
            System.out.println("Total (India): ₹" + indiaInvoice.getTotalAmount());

            Invoice usInvoice = new Invoice(amount, new USTaxCalculator());
            System.out.println("Total (US): $" + usInvoice.getTotalAmount());

            Invoice ukInvoice = new Invoice(amount, new UKTaxCalculator());
            System.out.println("Total (UK): £" + ukInvoice.getTotalAmount());
        }
    }

}
