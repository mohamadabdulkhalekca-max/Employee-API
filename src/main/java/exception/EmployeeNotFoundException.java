package employee_api.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long employeeId) {
        super("Employee with ID " + employeeId + " not found");
    }
}