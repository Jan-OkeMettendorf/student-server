package de.neuefische.springserver.controller;

import de.neuefische.springserver.modul.Student;
import de.neuefische.springserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("special")
public class SpecialStudentController {

    private final StudentService studentService;

    @Autowired
    public SpecialStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudentList(){
        return studentService.getList();
    }
    
}
