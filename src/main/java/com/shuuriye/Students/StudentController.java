package com.shuuriye.Students;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value="/students")
public class StudentController {

    //Dependency injection - DI
    private final StudentService studentService;

    //CI - Constructor injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //requests

    //get all students
    @GetMapping("/all")
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getStudents());
    }

    //student by id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void postStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void putStudent(@PathVariable Long id ,
                           @RequestBody Student student) {
        studentService.updateStudent(id , student);
    }
}
