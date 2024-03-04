package com.spring.repository.mapping;

import java.util.HashMap;
import java.util.Map;

public enum LeaveRequestMapper {
    ID("id", "id"),
    REQUEST_TYPE("request_type", "requestType"),

    STATUS("status", "status"),

    CREATE_DATE("create_Date", "createDate"),

    START_DATE("start_date", "startDate"),

    END_DATE("end_date", "endDate"),

    EMPLOYEE_ID("employee_id", "employeeId");

    private final String column;

    private final String field;

    private static final Map<String, String> COLUMN_FIELD_MAPPINGS = new HashMap<>();

    LeaveRequestMapper(String column, String field){
        this.column = column;
        this.field = field;
    }

    static {
        for (LeaveRequestMapper mapper : LeaveRequestMapper.values() ){
            COLUMN_FIELD_MAPPINGS.put(mapper.column, mapper.field);
        }

    }

    public static Map<String, String> getColumnFieldMMappings(){
        return COLUMN_FIELD_MAPPINGS;
    }

    public String getField() {
        return field;
    }
}


