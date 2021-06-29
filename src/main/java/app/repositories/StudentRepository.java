package app.repositories;

import app.model.Student;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {

    private List<Student> studentsList;

    @PostConstruct
    public void init(){
        studentsList = new ArrayList<>();
        studentsList.add(new Student(1L, "Mike", 21));
        studentsList.add(new Student(2L, "Max", 22));
        studentsList.add(new Student(3L, "Elena", 20));
        studentsList.add(new Student(4L, "Alex", 21));
        studentsList.add(new Student(5L, "Olga", 23));
    }

    public List<Student> getList(){
        return studentsList;
    }

    public void addProduct(Student student){
        studentsList.add(student);
    }

    public void remove(int id){
        studentsList.removeIf(b -> b.getId() == id);
    }
}
