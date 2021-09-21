package de.neuefische.springserver.repo;

import de.neuefische.springserver.modul.Student;

import java.util.*;

public class StudentRepo {

    private List<Student> studentRepo = new ArrayList<>();

    public StudentRepo(){
    }

    public StudentRepo(List<Student> studentRepo) {
        this.studentRepo = studentRepo;
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
        studentRepo.remove(id);
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
