package hieu.employeeservice.controller;

import hieu.employeeservice.dto.Employee;
import hieu.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee employee) {
        employeeService.sendEmployee(employee);
        return "Employee sent: " + employee.getName();
    }
}
