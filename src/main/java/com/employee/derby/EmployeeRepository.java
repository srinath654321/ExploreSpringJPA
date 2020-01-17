package com.employee.derby;

import com.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByJoiningDate(LocalDate localDate);

    List<Employee> findByJoiningDateLessThan(LocalDate localDate);

    List<Employee> findByJoiningDateGreaterThan(LocalDate localDate);
}
