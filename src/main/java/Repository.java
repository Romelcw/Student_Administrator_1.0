import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java .io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Repository {
    Logger logger = Logger.getLogger(getClass().getName());
    private static final String FILE = "File.txt";

    public void saveAll(Map <String,Student>students){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(FILE))) {
            for(Map.Entry<String,Student> studentEntry: students.entrySet()){
                String studentName = studentEntry.getKey();
                Student student = studentEntry.getValue();

                for(Map.Entry<String,Double> gradeEntry:student.getGrades().entrySet()){
                    writer.write(studentName + "," + gradeEntry.getKey() +"," + gradeEntry.getValue());
                    writer.newLine();
                    }
                }
        }catch (IOException e){
            logger.info("Could not save grades " + e.getMessage());
        }
    }

    public Map<String,Student> viewAll(){
        Map<String,Student> students=new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while((line=reader.readLine())!=null){
                String[] data = line.split(",");
                String name = data[0];
                String subject = data[1];
                double grade = Double.parseDouble(data[2]);

                Student student = students.get(name);

                if(student == null){
                    student = new Student(name);
                    students.put(name,student);
                }
                student.addGrade(subject,grade);
            }
        }catch (IOException e){
            logger.info("Could not view grades" + e.getMessage());
        }
        return students;
    }

    public void deleteStudent(String name){
        Map<String,Student> students = viewAll();
        if (students.remove(name) != null){
            saveAll(students);
        }
    }
    public void updateGrade(String name, String subject, double newGrade){
        Map<String,Student> students = viewAll();
        Student student = students.get(name);
        if (student!=null){
            student.addGrade(subject, newGrade);
            saveAll(students);
        }

    }

}
