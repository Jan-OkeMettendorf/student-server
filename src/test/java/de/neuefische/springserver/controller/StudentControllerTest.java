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
        StudentRepo studentRepo = new StudentRepo();
       studentRepo.add(new Student(1,"Max Muster"));
        studentRepo.add(new Student(3,"Max Muster"));
       studentRepo.add(new Student(4,"Max Muster"));
        studentRepo.add(new Student(5,"Max Muster"));
        studentRepo.add(new Student(2,"Maria Mops"));
        StudentService studentService = new StudentService(studentRepo);
        StudentController studentController = new StudentController(studentService);
        studentController.addStudent(new Student(1, "Sarah Drei"));
        studentController.addStudent(new Student(2, "Maik Mars"));
        studentController.addStudent(new Student(3, "Beate Biene"));
        System.out.println(studentController.getStudentById(3));

    }

}