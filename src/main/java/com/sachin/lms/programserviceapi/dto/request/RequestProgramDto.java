package com.sachin.lms.programserviceapi.dto.request;

import com.sachin.lms.programserviceapi.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestProgramDto {
    private String name;
    private BigDecimal price;
    private Date startDate;
    private List<Subject> subjects;
}