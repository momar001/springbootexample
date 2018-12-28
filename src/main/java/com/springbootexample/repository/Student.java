package com.springbootexample.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "student")
@TypeAlias("Student")
public class Student {
    @Id
    private ObjectId _id;
    private String name;
    private String address;
    private Integer rollNo;
    private Double marksPercentage;
    private StudentDetailPojo detail;

    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

}
