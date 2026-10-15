import java.util.HashMap;
import java.util.Map;

public class StudentAdministrator {
    Repository repository = new Repository();

    public void addStudent(String name, String subject , Double grade) {
        Map <String,Student> students = repository.viewAll();

        Student student = new Student(subject);

    }

    public void editGrade(String name, Double grade) {

    }

    public void removeStudent(String name) {

    }

    public Map<Student, Double> viewAll() {

    }

    public Map<String, Double> viewStudent(String name) {

    }
}


