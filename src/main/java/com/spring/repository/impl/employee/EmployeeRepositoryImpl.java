package com.spring.repository.impl.employee;

import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.repository.mapping.EmployeeMapper;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
class EmployeeRepositoryImpl implements EmployeeRepository {
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
    public void save(EmployeeEntity employeeEntity) {
    Connection connection = sql2o.open();
    Query query = connection.createQuery(EmployeeRepositoryConstants.SAVE);
        query
                .addParameter(EmployeeMapper.ID.getField(), employeeEntity.getId())
                .addParameter(EmployeeMapper.FIRST_NAME.getField(), employeeEntity.getFirstName())
                .addParameter(EmployeeMapper.LAST_NAME.getField(), employeeEntity.getLastName())
                .addParameter(EmployeeMapper.GENDER.getField(), employeeEntity.getGender())
                .addParameter(EmployeeMapper.AGE.getField(), employeeEntity.getAge())
                .addParameter(EmployeeMapper.USERNAME.getField(), employeeEntity.getUsername())
                .addParameter(EmployeeMapper.PASSWORD.getField(), employeeEntity.getPassword())
                .executeUpdate();
    }

    @Override
    public void update(EmployeeEntity employeeEntity) {
        Connection connection = sql2o.open();
        Query query = connection.createQuery(EmployeeRepositoryConstants.UPDATE);
         query
                 .addParameter(EmployeeMapper.ID.getField(), employeeEntity.getId())
                 .addParameter(EmployeeMapper.FIRST_NAME.getField(), employeeEntity.getFirstName())
                 .addParameter(EmployeeMapper.LAST_NAME.getField(), employeeEntity.getLastName())
                 .addParameter(EmployeeMapper.GENDER.getField(), employeeEntity.getGender())
                 .addParameter(EmployeeMapper.AGE.getField(), employeeEntity.getAge())
                 .addParameter(EmployeeMapper.USERNAME.getField(), employeeEntity.getUsername())
                 .addParameter(EmployeeMapper.PASSWORD.getField(), employeeEntity.getPassword())
                 .executeUpdate();

    }


    @Override
    public EmployeeEntity findEmployeeById(Long employeeId) {
        Connection connection = sql2o.open();
        Query query = connection.createQuery(EmployeeRepositoryConstants.FIND_BY_ID);
         query
                 .addParameter("id", employeeId)
                 .setColumnMappings(EmployeeMapper.getColumnFieldMappings());
        return query.executeAndFetchFirst(EmployeeEntity.class);
    }
}
