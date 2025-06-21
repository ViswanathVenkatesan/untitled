public class AdapterPatternExample {

    // Step 2: Target Interface
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Step 3: Adaptee Classes (third-party gateways with different interfaces)

    static class PayPalGateway {
        public void sendPayment(double amountInUSD) {
            System.out.println("Processing payment via PayPal: $" + amountInUSD);
        }
    }

    static class StripeGateway {
        public void makePayment(double amount) {
            System.out.println("Processing payment via Stripe: $" + amount);
        }
    }

    static class SquareGateway {
        public void doTransaction(double value) {
            System.out.println("Processing payment via Square: $" + value);
        }
    }

    // Step 4: Adapter Classes

    static class PayPalAdapter implements PaymentProcessor {
        private final PayPalGateway paypal;

        public PayPalAdapter(PayPalGateway paypal) {
            this.paypal = paypal;
        }

        public void processPayment(double amount) {
            paypal.sendPayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private final StripeGateway stripe;

        public StripeAdapter(StripeGateway stripe) {
            this.stripe = stripe;
        }

        public void processPayment(double amount) {
            stripe.makePayment(amount);
        }
    }

    static class SquareAdapter implements PaymentProcessor {
        private final SquareGateway square;

        public SquareAdapter(SquareGateway square) {
            this.square = square;
        }

        public void processPayment(double amount) {
            square.doTransaction(amount);
        }
    }

    // Step 5: Test the Adapter Implementation
    public static void main(String[] args) {
        // Create instances of gateways
        PayPalGateway paypalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();
        SquareGateway squareGateway = new SquareGateway();

        // Create adapters
        PaymentProcessor paypalProcessor = new PayPalAdapter(paypalGateway);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        PaymentProcessor squareProcessor = new SquareAdapter(squareGateway);

        // Process payments through unified interface
        System.out.println("=== Payment Processing System ===");
        paypalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(200.5);
        squareProcessor.processPayment(350.75);
    }
}

