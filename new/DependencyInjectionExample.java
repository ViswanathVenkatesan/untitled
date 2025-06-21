public class DependencyInjectionExample {

    // Model class
    static class Customer {
        private int id;
        private String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public String getName() { return name; }

        @Override
        public String toString() {
            return "Customer[ID=" + id + ", Name=" + name + "]";
        }
    }

    // Step 2: Repository Interface
    interface CustomerRepository {
        Customer findCustomerById(int id);
    }

    // Step 3: Concrete Repository Implementation
    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public Customer findCustomerById(int id) {
            // Simulating data access
            return new Customer(id, "John Doe");
        }
    }

    // Step 4: Service Class depending on CustomerRepository
    static class CustomerService {
        private CustomerRepository customerRepository;

        // Step 5: Constructor Injection
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public void getCustomerInfo(int id) {
            Customer customer = customerRepository.findCustomerById(id);
            System.out.println("Customer Found: " + customer);
        }
    }

    // Step 6: Main class to test Dependency Injection
    public static void main(String[] args) {
        // Create repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject repository into service using constructor injection
        CustomerService service = new CustomerService(repository);

        // Use the service
        service.getCustomerInfo(101);
    }
}

