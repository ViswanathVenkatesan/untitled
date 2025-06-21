public class CommandPatternExample {

    // Command Interface
    interface Command {
        void execute();
    }

    // Receiver Class
    static class Light {
        public void turnOn() {
            System.out.println("The light is ON");
        }

        public void turnOff() {
            System.out.println("The light is OFF");
        }
    }

    // Concrete Command: Turn Light On
    static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }
    }

    // Concrete Command: Turn Light Off
    static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }

    // Invoker Class
    static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            if (command != null) {
                command.execute();
            } else {
                System.out.println("No command set.");
            }
        }
    }

    // Main Method (Test Class)
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        // Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Remote Control
        RemoteControl remote = new RemoteControl();

        // Turn on the light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn off the light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}

