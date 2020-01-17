package com.employee.resources;

import com.employee.models.Employee;
import com.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee getEmployeeInfoById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
    }

    @PostMapping()
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
        employeeService.updateEmployee(employee, id);
    }

    @GetMapping("/joinDate/{date}")
    public List<Employee> getEmployeesByJoiningDate(@PathVariable String date){
       return employeeService.getEmployeesByJoiningDate(date);
    }

    @GetMapping("/lessJoinDate/{date}")
    public List<Employee> getEmployeesByJoiningDateBefore(@PathVariable String date){
        return employeeService.getEmployeesByJoiningDateBefore(date);
    }

    @GetMapping("/greaterJoinDate/{date}")
    public List<Employee> getEmployeesByJoiningDateAfter(@PathVariable String date){
        return employeeService.getEmployeesByJoiningDateAfter(date);
    }
}
