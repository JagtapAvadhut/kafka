package com.DemoSecurity.DemoSecurity.Repository;

import com.DemoSecurity.DemoSecurity.Entites.EmployeeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<EmployeeManagement, Long> {
}
