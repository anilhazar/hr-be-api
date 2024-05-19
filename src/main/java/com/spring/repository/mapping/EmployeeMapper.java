package com.spring.repository.mapping;

import java.util.HashMap;
import java.util.Map;

public enum EmployeeMapper {

    ID("ID", "id"),
    FIRST_NAME("FIRST_NAME", "firstName"),
    LAST_NAME("LAST_NAME", "lastName"),
    GENDER("GENDER", "gender"),
    BIRTHDAY("BIRTHDAY", "birthday"),
    AGE("AGE", "age"),
    EMAIL("EMAIL", "email"),
    USERNAME("USERNAME", "username"),
    PASSWORD("PASSWORD", "password");

    private static final Map<String, String> COLUMN_FIELD_MAPPINGS = new HashMap<>();

    static {
        for (EmployeeMapper mapper : EmployeeMapper.values()) {
            COLUMN_FIELD_MAPPINGS.put(mapper.column, mapper.field);
        }
    }

    private final String column;
    private final String field;

    EmployeeMapper(String column, String field) {
        this.column = column;
        this.field = field;
    }

    public static Map<String, String> getColumnFieldMappings() {
        return COLUMN_FIELD_MAPPINGS;
    }

    public String getField() {
        return field;
    }


}
