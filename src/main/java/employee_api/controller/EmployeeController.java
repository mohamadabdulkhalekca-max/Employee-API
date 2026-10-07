package employee_api.controller;

import employee_api.dto.EmployeeRequest;
import employee_api.dto.EmployeeResponse;
import employee_api.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeResponse> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public EmployeeResponse createEmployee(
            @Valid @RequestBody EmployeeRequest request) {

        return employeeService.createEmployee(request);
    }

    @PutMapping("/employees/{employeeId}")
    public EmployeeResponse updateEmployee(
            @PathVariable Long employeeId,
            @Valid @RequestBody EmployeeRequest request) {

        return employeeService.updateEmployee(employeeId, request);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {

        employeeService.deleteEmployee(employeeId);

        return "Employee deleted";
    }
}



/*
package employee_api.controller;

import employee_api.model.Employee;
import employee_api.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(
            @Valid
            @PathVariable Long employeeId,
            @RequestBody Employee employee) {

        return employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "Employee deleted";
    }
}
*/
/*
package employee_api.controller;

import employee_api.model.Employee;
import employee_api.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class EmployeeController {

    //private List<Employee> employees = new ArrayList<>();

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
    }
    
    /*
   @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employees;
    }   
    */
    
    /*@GetMapping("/employees")
    public List<Employee> getEmployees() {
    return employeeRepository.findAll();
    }
    
    /*
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        // In a real application, you would save the employee to a database here
        return employee;
    }
    */

    
    /*@PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
    return employeeRepository.save(employee);
    }
    
    /*
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

    employees.removeIf(employee -> employee.getEmployeeId() == employeeId);

    return "Employee deleted";
    }
    */
    
    /*@DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {

    employeeRepository.deleteById(employeeId);

    return "Employee deleted";
    }
    
    /*
    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getEmployeeId() == employeeId) {
                employees.set(i, updatedEmployee);
                return updatedEmployee;
            }
        }
        return null; // Employee not found
    }
    */
/*
   @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {
    Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
    if (optionalEmployee.isPresent()) {
        Employee existingEmployee = optionalEmployee.get();
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setTitle(updatedEmployee.getTitle());
        return employeeRepository.save(existingEmployee);
    } else {
        return null; // Employee not found
    }
    }

}*/