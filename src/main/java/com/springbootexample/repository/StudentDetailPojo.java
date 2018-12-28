package com.springbootexample.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetailPojo {
    private String _id;
    private String ambition;
    private String favoriteSubject;
    private String lastGrade;
}
