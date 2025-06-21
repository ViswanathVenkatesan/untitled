public class StrategyPatternExample {

    // Strategy Interface
    interface PaymentStrategy {
        void pay(double amount);
    }

    // Concrete Strategy 1: Credit Card Payment
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String cardHolderName;

        public CreditCardPayment(String cardNumber, String cardHolderName) {
            this.cardNumber = cardNumber;
            this.cardHolderName = cardHolderName;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid $" + amount + " using Credit Card [" + cardNumber + "] - " + cardHolderName);
        }
    }

    // Concrete Strategy 2: PayPal Payment
    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid $" + amount + " using PayPal account: " + email);
        }
    }

    // Context Class
    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(double amount) {
            if (paymentStrategy == null) {
                System.out.println("Payment method not selected!");
            } else {
                paymentStrategy.pay(amount);
            }
        }
    }

    // Main Method (Test Program)
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Using Credit Card Payment
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432", "John Doe"));
        context.executePayment(250.0);

        // Using PayPal Payment
        context.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        context.executePayment(100.0);
    }
}

