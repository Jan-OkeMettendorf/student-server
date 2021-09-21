package de.neuefische.springserver.controller;

import de.neuefische.springserver.modul.Student;
import de.neuefische.springserver.repo.StudentRepo;
import de.neuefische.springserver.service.StudentService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    @Test
    public void TestAddStudent(){
        List<Student> students = new ArrayList<>();
        StudentRepo studentRepo = new StudentRepo(students);
        studentRepo.add(new Student(1,"Max Muster"));
        studentRepo.add(new Student(3,"Max Muster"));
        studentRepo.add(new Student(4,"Max Muster"));
        studentRepo.add(new Student(5,"Max Muster"));
        studentRepo.add(new Student(2,"Maria Mops"));
        StudentService studentService = new StudentService(studentRepo);
//        StudentController studentController = new StudentController(studentService);
//        studentController.addStudent(new Student(3, "Sarah Drei"));
        System.out.println(studentService.getStudentListByName("Max Muster"));
//        System.out.println(studentController.addStudent(new Student(4,"Katrin Vier")));
//        System.out.println(studentController.getList());
//        System.out.println(studentController.getStudentById(4));
    }

}