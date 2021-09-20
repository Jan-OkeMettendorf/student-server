package de.neuefische.springserver.controller;

import de.neuefische.springserver.modul.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@RestController
@RequestMapping("student")
public class StudentController {

    List<Student> students;

    @GetMapping
    public List<Student> getList(){

        List<Student> students = List.of(
                new Student(1, "Beate"),
                new Student(2, "Peter"),
                new Student(3, "Sarah"),
                new Student(4, "Max"),
                new Student(5, "Celina")
        );
        return students;
    }

}
