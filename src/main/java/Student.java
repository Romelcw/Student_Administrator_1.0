import java.util.HashMap;
import java.util.Map;

public class Student {
    private final String subject;
    private final Map<String, Double> grades;

    public  Student(String studentName){
        this.subject =studentName;
        this.grades = new HashMap<>();
    }
    public String getSubject(){
        return this.subject;
    }
    public  Map<String,Double> getGrades(){
        return this.grades;
    }
    public Double getGrade(String subject){
        return grades.get(subject);
    }
    public void addGrade(String subject, double grade){
        if(grade < 0 || grade > 100){
            throw new InvalidGrade("Grade must be between 0 and 100");
        }
        grades.put(subject,grade);
    }
}
 