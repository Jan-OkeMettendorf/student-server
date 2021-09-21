package de.neuefische.springserver.controller;

import de.neuefische.springserver.modul.Student;
import de.neuefische.springserver.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("student")
public class StudentController {

    private StudentService service = new StudentService();

//    public StudentController(StudentService service) {
//        this.service = service;
//    }

    @GetMapping
    public List<Student> getList(@RequestParam Optional<String> search){
        if(search.isPresent()){
            return service.getStudentListByName(search.get());
        }
        return service.getList();
    }

    @GetMapping (path = "{id}")
    public Student getStudentById(@PathVariable int id){
        return service.getStudent(id);
    }

    @PutMapping
    public Student addStudent(@RequestBody Student student){
        return service.add(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable int id){
        service.deleteStudent(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentController that = (StudentController) o;
        return Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service);
    }

    @Override
    public String toString() {
        return "StudentController{" +
                "service=" + service +
                '}';
    }
}