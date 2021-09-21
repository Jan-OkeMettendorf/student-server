package de.neuefische.springserver.service;

import de.neuefische.springserver.modul.Student;
import de.neuefische.springserver.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getList(){
        return studentRepo.list();
    }

    public Student getStudent(int id){
        return studentRepo.getStudent(id);
    }

    public Student add(Student student){
        return studentRepo.add(student);
    }

    public List<Student> getStudentListByName(String name){
        return studentRepo.getStudentsByName(name);
    }

    public void deleteStudent(int id){
        studentRepo.deleteStudent(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentService that = (StudentService) o;
        return Objects.equals(studentRepo, that.studentRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentRepo);
    }

    @Override
    public String toString() {
        return "StudentService{" +
                "studentRepo=" + studentRepo +
                '}';
    }
}
