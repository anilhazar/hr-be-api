package com.spring.repository.mapping;

import java.util.HashMap;
import java.util.Map;

public enum EmployeeMapper {
    ID("ID", "id"),
    FIRST_NAME("FIRST_NAME", "firstName"),
    LAST_NAME("LAST_NAME", "lastName"),
    GENDER("GENDER", "gender"),
    AGE("age", "age"),
    BIRTHDAY("BIRTHDAY", "birthday"),
    USERNAME("USERNAME", "username"),
    PASSWORD("PASSWORD", "password");

    private final String column;
    private final String field;
    private static final Map<String, String> COLUMN_FIELD_MAPPINGS = new HashMap<>();

    EmployeeMapper(String column, String field) {
        this.column = column;
        this.field = field;
    }

    static {
        for (EmployeeMapper mapper : EmployeeMapper.values()) {
            COLUMN_FIELD_MAPPINGS.put(mapper.column, mapper.field);
        }
    }

    public static Map<String, String> getColumnFieldMappings() {
        return COLUMN_FIELD_MAPPINGS;
    }

    public String getField() {
        return field;
    }
}
