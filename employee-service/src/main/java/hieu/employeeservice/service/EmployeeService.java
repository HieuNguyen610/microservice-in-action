package hieu.employeeservice.service;

import hieu.employeeservice.dto.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final StreamBridge streamBridge;

    public void sendEmployee(Employee employee) {
        streamBridge.send("output",employee);
    }
}
