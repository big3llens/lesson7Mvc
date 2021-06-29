package app.services;

import app.model.Student;
import app.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServis {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServis(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getList(){
        return studentRepository.getList();
    }

    public void addStudent(Student student){
        studentRepository.addProduct(student);
    }

    public void remove(int id){
        studentRepository.remove(id);
    }
}

