package de.neuefische.springserver.repo;

import de.neuefische.springserver.modul.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Repository
public class StudentRepo {

    private List<Student> studentRepo = new ArrayList<>();

    public StudentRepo(){
    }

    public List<Student> list(){
        return studentRepo;
    }

    public Student getStudent(int id){

        for (Student student : studentRepo) {
            if (student.getId() == id){
                return student;
            }
        }
        throw new IllegalArgumentException("Student not found. ID: " + id );
    }

    public List<Student> getStudentsByName(String name){

        List<Student> listStudentByName = new ArrayList<>();

        for (Student student : studentRepo) {
            if(student.getName().equals(name)){
                if(student.getName().toLowerCase().contains(name.toLowerCase())){
                    listStudentByName.add(student);
                }
            }
        }
        return listStudentByName;
    }

    public void deleteStudent(int id){

        int studentRepoSize = studentRepo.size();

        for (int i = 0; i < studentRepoSize; i++) {
            Student student = studentRepo.get(i);
            if(student.getId() == id){
                studentRepo.remove(student);
                i--;
                studentRepoSize = studentRepoSize-1;
            }
        }
    }

    public Student add(Student student){
        studentRepo.add(student);
        return student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRepo that = (StudentRepo) o;
        return Objects.equals(studentRepo, that.studentRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentRepo);
    }

    @Override
    public String toString() {
        return "StudentRepo{" +
                "studentRepo=" + studentRepo +
                '}';
    }
}
