public class BuilderPatternExample {

    // Step 2: Product class
    static class Computer {
        // Required attributes
        private final String CPU;
        private final String RAM;

        // Optional attributes
        private final String storage;
        private final String graphicsCard;
        private final String operatingSystem;

        // Step 4: Private constructor
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
            this.operatingSystem = builder.operatingSystem;
        }

        // For displaying the configuration
        public void displayConfiguration() {
            System.out.println("Computer Configuration:");
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM);
            System.out.println("Storage: " + (storage != null ? storage : "Not specified"));
            System.out.println("Graphics Card: " + (graphicsCard != null ? graphicsCard : "Not specified"));
            System.out.println("Operating System: " + (operatingSystem != null ? operatingSystem : "Not specified"));
            System.out.println("----------------------------------");
        }

        // Step 3: Static nested Builder class
        static class Builder {
            // Required attributes
            private final String CPU;
            private final String RAM;

            // Optional attributes
            private String storage;
            private String graphicsCard;
            private String operatingSystem;

            public Builder(String CPU, String RAM) {
                this.CPU = CPU;
                this.RAM = RAM;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Builder setOperatingSystem(String operatingSystem) {
                this.operatingSystem = operatingSystem;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Step 5: Test the Builder pattern
    public static void main(String[] args) {
        // Basic computer with required attributes only
        Computer basicComputer = new Computer.Builder("Intel i3", "4GB").build();
        basicComputer.displayConfiguration();

        // Gaming computer with all attributes
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11 Pro")
                .build();
        gamingComputer.displayConfiguration();

        // Workstation with some optional attributes
        Computer workstation = new Computer.Builder("AMD Ryzen 9", "64GB")
                .setStorage("2TB NVMe")
                .setOperatingSystem("Ubuntu Linux")
                .build();
        workstation.displayConfiguration();
    }
}

