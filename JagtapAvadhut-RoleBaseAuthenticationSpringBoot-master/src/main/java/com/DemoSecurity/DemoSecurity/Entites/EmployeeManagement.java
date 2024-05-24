package com.DemoSecurity.DemoSecurity.Entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeManagement {
    @Id
    private Long id;
    private String empFirstName;
    private String empLastName;
    private Date createdAt;
    private Date updatedAt;
    private Long refById;
    private String department;

    private Long geoPointStart;
    private Long geoPointEnd;

}
