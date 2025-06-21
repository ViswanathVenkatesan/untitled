public class DecoratorPatternExample {

    // Step 2: Component Interface
    interface Notifier {
        void send(String message);
    }

    // Step 3: Concrete Component
    static class EmailNotifier implements Notifier {
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }

    // Step 4: Abstract Decorator
    static abstract class NotifierDecorator implements Notifier {
        protected Notifier wrappedNotifier;

        public NotifierDecorator(Notifier notifier) {
            this.wrappedNotifier = notifier;
        }

        public void send(String message) {
            wrappedNotifier.send(message);
        }
    }

    // Step 4.1: Concrete Decorators

    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            sendSMS(message);
        }

        private void sendSMS(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            sendSlack(message);
        }

        private void sendSlack(String message) {
            System.out.println("Sending Slack message: " + message);
        }
    }

    // Step 5: Test the Decorator Implementation
    public static void main(String[] args) {
        // Base notifier
        Notifier baseNotifier = new EmailNotifier();

        // Decorate with SMS
        Notifier smsNotifier = new SMSNotifierDecorator(baseNotifier);

        // Decorate with Slack on top of SMS
        Notifier fullNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println("=== Sending Notification ===");
        fullNotifier.send("System maintenance scheduled at 10 PM tonight.");
    }
}

