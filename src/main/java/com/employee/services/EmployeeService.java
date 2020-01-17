package com.employee.services;

import com.employee.derby.EmployeeRepository;
import com.employee.models.Employee;
import com.employee.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void  deleteEmployee(long id){
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Employee employee, long id){
        employeeRepository.findById(id).ifPresent( emp -> {
            employee.setId(id);
            employeeRepository.save(employee);
        });
    }

    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.isPresent() ? employee.get() : null;
    }

    public List<Employee> getEmployeesByJoiningDate(String date){
        return employeeRepository.findByJoiningDate(EmployeeUtil.parseLocalDateString(date));
    }

    public List<Employee> getEmployeesByJoiningDateBefore(String date){
        return employeeRepository.findByJoiningDateLessThan(EmployeeUtil.parseLocalDateString(date));
    }


    public List<Employee> getEmployeesByJoiningDateAfter(String date){
        return employeeRepository.findByJoiningDateGreaterThan(EmployeeUtil.parseLocalDateString(date));
    }
}
