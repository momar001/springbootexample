package com.springbootexample.controller;

import com.springbootexample.repository.TestCollection;
import com.springbootexample.repository.TestCollectionPojo;
import com.springbootexample.service.TestService;
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
@Api(tags = {"Test Controller"})
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/testMethod1/{id}")
    public String testMethod1(@RequestParam @NotNull @Valid ObjectId id ){
        TestCollection collection = testService.getCollectionFromId(id);
        log.info("JSON:::" + collection != null ? collection.toString() : "No data found");
        return "Greetings...";
    }

    @GetMapping("/testcollection/{field1}")
    public @ResponseBody List<TestCollection> getCollectionFromField1(@RequestParam @NotNull @Valid String field1) {
        List<TestCollection> collection = testService.getCollectionFromField1(field1);
        log.info("Result: {}", collection);
        return collection;
    }

    @GetMapping("/testcollection/find-by-likes")
    public @ResponseBody List<TestCollection> findByLikesCount(@RequestParam @NotNull @Valid Integer likesCount) {
        List<TestCollection> collection = testService.findByLikesCount(likesCount);
        log.info("Result: {}", collection);
        return collection;
    }

    @DeleteMapping("/testcollection/{field1}")
    public @ResponseBody Boolean deleteByField1(@RequestParam @NotNull @Valid String field1) {
        Long response = testService.deleteByField1(field1);
        log.info("No of Records Deleted: {}", response);
        return Boolean.TRUE;
    }

    @PostMapping("/testcollection")
    public @ResponseBody Boolean saveTestCollection(@Valid @NotNull @RequestBody TestCollectionPojo testCollection) {
        return testService.saveTestCollection(testCollection);
    }

    @GetMapping("/testcollection/all")
    public @ResponseBody List<TestCollection> getAll() {
        List<TestCollection> collection = testService.getTestCollectionsAll();
        log.info("Result: {}", collection);
        return collection;
    }

    @GetMapping("/testcollection/advance/{details1}")
    public @ResponseBody List<TestCollection> getByDetails1(@Valid @NotNull @RequestParam String details1) {
        List<TestCollection> collection = testService.findByDetails1(details1);
        log.info("Result: {}", collection);
        return collection;
    }

}