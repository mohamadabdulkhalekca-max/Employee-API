package employee_api.dto;

public class EmployeeResponse {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String title;

    public EmployeeResponse(
            Long employeeId,
            String firstName,
            String lastName,
            String email,
            String title) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }
}