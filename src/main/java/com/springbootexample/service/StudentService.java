package com.springbootexample.service;

import com.springbootexample.repository.Student;
import com.springbootexample.repository.StudentDetailPojo;
import com.springbootexample.repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudentFromId(ObjectId id){
        return studentRepository.findBy_id(id);
    }

    public List<Student> findByName(String name){
        return studentRepository.findByNameOrderByNameAsc(name);
    }

    public List<Student> searchByName(String name){
        return studentRepository.findStudentByNameIsLike(name);
    }

    public List<Student> findByRollNo(Integer rollNo){
        return studentRepository.findByRollNoByQuery(rollNo);
    }

    public List<Student> findToppers(){
        return studentRepository.findToppers();
    }

    public List<Student> getStudentsAll(){
        return studentRepository.findAll();
    }

    public boolean saveStudent(Student student) {
        Student studentDoc = Student.builder().build();
        BeanUtils.copyProperties(student,studentDoc);
        //Student.set_id(ObjectId.get());
        studentRepository.save(studentDoc);
        return true;
    }

    public long deleteStudent(Integer rollNo){
        return studentRepository.deleteByRollNo(rollNo);
    }

    public  List<Student>  findByFavoriteSubject(String favSubject){
        return studentRepository.findByDetail_FavoriteSubjectLike(favSubject);
    }

}
