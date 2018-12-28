package com.springbootexample.controller;

import com.springbootexample.repository.Student;
import com.springbootexample.repository.StudentDetailPojo;
import com.springbootexample.service.StudentService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Slf4j
@Api(tags = {"Student Controller"})
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student/{id}")
    public Student getById(@PathVariable("id") ObjectId id){
        Student student = studentService.getStudentFromId(id);
        log.info("JSON:::" + student != null ? student.toString() : "No data found");
        return student;
    }

    @GetMapping("/student/find-by-name")
    public @ResponseBody List<Student> findByName(@RequestParam @NotNull @Valid String name) {
        List<Student> students = studentService.findByName(name);
        log.info("Find student by exact Name: {}", students);
        return students;
    }

    @GetMapping("/student/find-by-rollno")
    public @ResponseBody List<Student> findByRollNo(@RequestParam @NotNull @Valid Integer rollNo) {
        List<Student> students = studentService.findByRollNo(rollNo);
        log.info("Find student by Roll No: {}", students);
        return students;
    }

    @GetMapping("/student/find-by-fav-subject")
    public @ResponseBody List<Student> findByFavoriteSubject(@Valid @NotNull @RequestParam String subject) {
        List<Student> collection = studentService.findByFavoriteSubject(subject);
        log.info("findByFavoriteSubject: {}", collection);
        return collection;
    }

    @GetMapping("/student/search")
    public @ResponseBody List<Student> searchByName(@RequestParam @NotNull @Valid String name) {
        List<Student> students = studentService.searchByName(name);
        log.info("Search By Name: {}", students);
        return students;
    }

    @GetMapping("/student/toppers")
    public @ResponseBody List<Student> findToppers() {
        List<Student> students = studentService.findToppers();
        log.info("Toppers: {}", students);
        return students;
    }

    @DeleteMapping("/student")
    public @ResponseBody Boolean delete(@RequestParam @NotNull @Valid Integer rollNo) {
        Long response = studentService.deleteStudent(rollNo);
        log.info("No of Students Deleted: {}", response);
        return Boolean.TRUE;
    }

    @PostMapping("/student")
    public @ResponseBody Boolean saveTestCollection(@Valid @NotNull @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/student/all")
    public @ResponseBody List<Student> getAll() {
        List<Student> collection = studentService.getStudentsAll();
        log.info("Result: {}", collection);
        return collection;
    }

}