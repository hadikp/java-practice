package zaropot.students;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TeacherNotebook {

    private List<Student> students = new ArrayList<>();

    public void readFromFile(Path path) {
        List<String> dataFromFile = readFile(path);
        int counter = 0;
        for(String st: dataFromFile) {
            String[] dataSplit = st.split(";");
            String name = dataSplit[0];
            String className = dataSplit[1];
            this.students.add(new Student(name, className));

            for(int i = 2; i < dataSplit.length; i++) {
                int grade = Integer.parseInt(dataSplit[i]);
                students.get(counter).addGrade(grade);
            }
            counter++;
        }

    }
    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read file!", ioe);
        }
    }

    public List<String> findFailingStudents(){
        List<String> result = new ArrayList<>();
        for(Student s: students) {
           double ave = s.getGrades().stream().mapToInt(m -> m).average().getAsDouble();
           if(ave < 2) {
               result.add(s.getName());
           }
        }
        return result;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
