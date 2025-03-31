package hieu.departmentservice.service.impl;

import hieu.departmentservice.entity.Department;
import hieu.departmentservice.repository.DepartmentRepository;
import hieu.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "department-service")
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        log.info("Saving department");
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        log.info("Getting department by id = {}", departmentId);
        return departmentRepository.findById(departmentId)
                .orElseThrow(()-> new IllegalArgumentException("Department id = " + departmentId + " not found"));
    }
}
