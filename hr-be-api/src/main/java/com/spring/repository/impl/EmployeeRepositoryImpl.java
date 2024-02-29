package com.spring.repository.impl;

import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.repository.mapping.EmployeeMapper;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final Sql2o sql2o;

    public EmployeeRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<EmployeeEntity> findallEmployee() {


        try (Connection connection = sql2o.open()) {
            Query query = connection.createQuery(EmployeeRepositoryConstants.FIND_ALL);
            return query.executeAndFetch(EmployeeEntity.class);
        }


    }
    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
    Connection connection = sql2o.open();
    Query query = connection.createQuery(EmployeeRepositoryConstants.SAVE);
    query.addParameter("name", employeeEntity.getName());
    query.addParameter("surname", employeeEntity.getSurname());
    query.addParameter("gender", employeeEntity.getGender());
    query.addParameter("age", employeeEntity.getAge());
    query.addParameter("username", employeeEntity.getUsername());
    query.addParameter("password", employeeEntity.getPassword());
    query.executeUpdate();
    return employeeEntity;
    }

    @Override
    public EmployeeEntity update(EmployeeEntity employeeEntity) {
        Connection connection = sql2o.open();
        Query query = connection.createQuery(EmployeeRepositoryConstants.UPDATE);
        query.addParameter("id", employeeEntity.getId());
        query.addParameter("name", employeeEntity.getName());
        query.addParameter("surname", employeeEntity.getSurname());
        query.addParameter("gender", employeeEntity.getGender());
        query.addParameter("age", employeeEntity.getAge());
        query.addParameter("username", employeeEntity.getUsername());
        query.addParameter("password", employeeEntity.getPassword());
        query.executeUpdate();
        return  employeeEntity;
    }


    @Override
    public EmployeeEntity findEmployeeById(Long employeeId) {
        Connection connection = sql2o.open();
        Query query = connection.createQuery(EmployeeRepositoryConstants.FIND_BY_ID)
                                            .addParameter("id", employeeId)
                                            .setColumnMappings(EmployeeMapper.getColumnFieldMappings());
        return query.executeAndFetchFirst(EmployeeEntity.class);
    }
}
