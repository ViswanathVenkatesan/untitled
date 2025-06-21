import java.util.ArrayList;
import java.util.List;

// Step 2: Subject Interface
interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Step 4: Observer Interface
interface Observer {
    void update(String stockName, double price);
}

// Step 3: Concrete Subject
class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public void setStockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.stockPrice = price;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }
}

// Step 5: Concrete Observers
class MobileApp implements Observer {
    private final String user;

    public MobileApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double price) {
        System.out.println("MobileApp [" + user + "]: " + stockName + " updated to $" + price);
    }
}

class WebApp implements Observer {
    private final String user;

    public WebApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double price) {
        System.out.println("WebApp [" + user + "]: " + stockName + " updated to $" + price);
    }
}

// Step 6: Test Class
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer user1Mobile = new MobileApp("Alice");
        Observer user1Web = new WebApp("Alice");
        Observer user2Mobile = new MobileApp("Bob");

        // Register observers
        stockMarket.registerObserver(user1Mobile);
        stockMarket.registerObserver(user1Web);
        stockMarket.registerObserver(user2Mobile);

        System.out.println("--- Updating stock: AAPL ---");
        stockMarket.setStockPrice("AAPL", 150.75);

        System.out.println("\n--- Updating stock: TSLA ---");
        stockMarket.setStockPrice("TSLA", 722.50);

        // Remove an observer
        stockMarket.removeObserver(user1Web);

        System.out.println("\n--- Updating stock: GOOGL (after removing one observer) ---");
        stockMarket.setStockPrice("GOOGL", 2800.10);
    }
}

