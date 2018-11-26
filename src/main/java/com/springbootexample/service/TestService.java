package com.springbootexample.service;

import com.springbootexample.repository.TestCollection;
import com.springbootexample.repository.TestCollectionPojo;
import com.springbootexample.repository.TestCollectionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestCollectionRepository testCollectionRepository;

    public TestCollection getCollectionFromId(ObjectId id){
        return testCollectionRepository.findBy_id(id);
    }

    public List<TestCollection> getCollectionFromField1(String field1){
        return testCollectionRepository.findByField1OrderByField2Desc(field1);
    }

    public List<TestCollection> getTestCollectionsAll(){
        return testCollectionRepository.findAll();
    }

    public boolean saveTestCollection(TestCollectionPojo testCollectionPojo) {
        TestCollection testCollection = TestCollection.builder().build();
        BeanUtils.copyProperties(testCollectionPojo,testCollection);
        //testCollection.set_id(ObjectId.get());
        testCollectionRepository.save(testCollection);
        return true;
    }

    public long deleteByField1(String field1){
        return testCollectionRepository.deleteByField1(field1);
    }

    public  List<TestCollection>  findByLikesCount(Integer likesCount){
        return testCollectionRepository.findByLikesCount(likesCount);
    }

    public  List<TestCollection>  findByDetails1(String details1){
        return testCollectionRepository.findByDetails_Details1(details1);
    }

}
