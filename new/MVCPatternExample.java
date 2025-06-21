public class MVCPatternExample {

    // Model Class
    static class Student {
        private String id;
        private String name;
        private String grade;

        public Student(String id, String name, String grade) {
            this.id = id;
            this.name = name;
            this.grade = grade;
        }

        // Getters and setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getGrade() { return grade; }
        public void setGrade(String grade) { this.grade = grade; }
    }

    // View Class
    static class StudentView {
        public void displayStudentDetails(String id, String name, String grade) {
            System.out.println("Student Details:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
            System.out.println();
        }
    }

    // Controller Class
    static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public void updateView() {
            view.displayStudentDetails(model.getId(), model.getName(), model.getGrade());
        }
    }

    // Main Method (Test MVC Implementation)
    public static void main(String[] args) {
        // Create model
        Student student = new Student("S123", "Alice", "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Initial display
        controller.updateView();

        // Update model data using controller
        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A+");

        // Display updated data
        controller.updateView();
    }
}
