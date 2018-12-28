package com.springbootexample.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    Student findBy_id(ObjectId id);

    List<Student> findByNameOrderByNameAsc(String name);

    List<Student> findStudentByNameIsLike(String name);

    @Query("{rollNo: ?0}")
    List<Student> findByRollNoByQuery(Integer rollNo);

    @Query("{marksPercentage: {$gt: 90}}")
    List<Student> findToppers();

    long deleteByRollNo(Integer rollNo);

    List<Student> findByDetail_FavoriteSubjectLike(String favSubject);

}