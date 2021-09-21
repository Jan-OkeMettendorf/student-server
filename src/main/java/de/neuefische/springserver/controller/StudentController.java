package de.neuefische.springserver.controller;

import de.neuefische.springserver.modul.Student;
import de.neuefische.springserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getList(@RequestParam Optional<String> name){
        if(name.isPresent()){
            return studentService.getStudentListByName(name.get());
        }
        return studentService.getList();
    }

    @GetMapping (path = "{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @PutMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.add(student);
    }

    @DeleteMapping(path ="{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentController that = (StudentController) o;
        return Objects.equals(studentService, that.studentService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentService);
    }

    @Override
    public String toString() {
        return "StudentController{" +
                "service=" + studentService +
                '}';
    }
}