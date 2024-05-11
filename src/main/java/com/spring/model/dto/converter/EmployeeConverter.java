package com.spring.model.dto.converter;

import com.spring.model.dto.request.EmployeeCreateRequest;
import com.spring.model.dto.response.EmployeeResponse;
import com.spring.model.entity.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;

public final class EmployeeConverter {

    private EmployeeConverter() {

    }

    public static EmployeeEntity toEntity(EmployeeCreateRequest employeeCreateRequest) {
        return new EmployeeEntity(
                employeeCreateRequest.getFirstName(),
                employeeCreateRequest.getLastName(),
                employeeCreateRequest.getGender(),
                employeeCreateRequest.getAge(),
                employeeCreateRequest.getEmail());
    }

    public static EmployeeResponse toResponse(EmployeeEntity employeeEntity) {
        return new EmployeeResponse(
                employeeEntity.getFirstName(),
                employeeEntity.getLastName(),
                employeeEntity.getAge(),
                employeeEntity.getGender(),
                employeeEntity.getEmail()
        );
    }

    public static List<EmployeeResponse> toResponse(List<EmployeeEntity> employeeEntities) {
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            EmployeeResponse employeeResponse = toResponse(employeeEntity);
            employeeResponses.add(employeeResponse);
        }
        return employeeResponses;

    }
}
