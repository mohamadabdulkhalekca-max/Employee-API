package employee_api.service;

import employee_api.dto.EmployeeRequest;
import employee_api.dto.EmployeeResponse;
import employee_api.exception.EmployeeNotFoundException;
import employee_api.model.Employee;
import employee_api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponse> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public EmployeeResponse createEmployee(EmployeeRequest request) {

        Employee employee = new Employee(
                null,
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getTitle()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        return toResponse(savedEmployee);
    }

    public EmployeeResponse updateEmployee(
            Long employeeId,
            EmployeeRequest request) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));

        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setTitle(request.getTitle());

        Employee updatedEmployee = employeeRepository.save(employee);

        return toResponse(updatedEmployee);
    }

    public void deleteEmployee(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new EmployeeNotFoundException(employeeId);
        }

        employeeRepository.deleteById(employeeId);
    }

    private EmployeeResponse toResponse(Employee employee) {

        return new EmployeeResponse(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getTitle()
        );
    }
}



/*
package employee_api.service;

import employee_api.model.Employee;
import employee_api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import employee_api.exception.EmployeeNotFoundException;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long employeeId, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setTitle(employee.getTitle());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
*/