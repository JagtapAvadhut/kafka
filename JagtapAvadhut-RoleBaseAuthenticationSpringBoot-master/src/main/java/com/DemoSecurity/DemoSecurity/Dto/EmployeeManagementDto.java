package com.DemoSecurity.DemoSecurity.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeManagementDto {
    private String empFirstName;
    private String empLastName;
    private Date createdAt;
    private Date updatedAt;
    private Long refById;
    private String department;
}
