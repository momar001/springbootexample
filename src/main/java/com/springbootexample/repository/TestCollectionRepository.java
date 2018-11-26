package com.springbootexample.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TestCollectionRepository extends MongoRepository<TestCollection, String> {
    TestCollection findBy_id(ObjectId id);

    List<TestCollection> findByField1OrderByField2Desc(String field1);

    @Query("{field1:'?0'}")
    List<TestCollection> findByField1ByQuery(String field1);

    @Query("{likes: {$gt: ?0}}")
    List<TestCollection> findByLikesCount(Integer likes);

    long deleteByField1(String field1);

    List<TestCollection> findByDetails_Details1(String details1);

}