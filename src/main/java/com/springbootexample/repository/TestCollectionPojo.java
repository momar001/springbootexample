package com.springbootexample.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestCollectionPojo {
    private String _id;
    private String field1;
    private String field2;
    private Integer likes;
    private TestCollectionDetailPojo details;
}
