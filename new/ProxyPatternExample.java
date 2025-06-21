public class ProxyPatternExample {

    // Step 2: Subject Interface
    interface Image {
        void display();
    }

    // Step 3: Real Subject Class
    static class RealImage implements Image {
        private final String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromRemoteServer();
        }

        private void loadFromRemoteServer() {
            System.out.println("Loading image from remote server: " + filename);
        }

        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    // Step 4: Proxy Class
    static class ProxyImage implements Image {
        private final String filename;
        private RealImage realImage;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename); // lazy initialization
            } else {
                System.out.println("Image already loaded. Using cached image.");
            }
            realImage.display();
        }
    }

    // Step 5: Test the Proxy Implementation
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("\n--- First time display (loads image) ---");
        image1.display();

        System.out.println("\n--- Second time display (uses cached image) ---");
        image1.display();

        System.out.println("\n--- Display another image ---");
        image2.display();
    }
}
