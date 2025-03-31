package hieu.departmentservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DepartmentDto {

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
