package com.spring.repository.impl.employee;

import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.repository.mapping.EmployeeMapper;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.math.BigInteger;
import java.util.List;

@Repository
class EmployeeRepositoryImpl implements EmployeeRepository {
    private final Sql2o sql2o;

    public EmployeeRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<EmployeeEntity> findAllEmployee() {

        try (Connection connection = sql2o.open()) {
            try (Query query = connection.createQuery(EmployeeRepositoryConstants.FIND_ALL)) {
                return query.executeAndFetch(EmployeeEntity.class);
            }
        }
    }
    @Override
    public void save(EmployeeEntity employeeEntity) {
        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(EmployeeRepositoryConstants.SAVE, true)
                     .addParameter(EmployeeMapper.FIRST_NAME.getField(), employeeEntity.getFirstName())
                     .addParameter(EmployeeMapper.LAST_NAME.getField(), employeeEntity.getLastName())
                     .addParameter(EmployeeMapper.GENDER.getField(), employeeEntity.getGender())
                     .addParameter(EmployeeMapper.AGE.getField(), employeeEntity.getAge())
                     .addParameter(EmployeeMapper.EMAIL.getField(), employeeEntity.getEmail())
                     .addParameter(EmployeeMapper.USERNAME.getField(), employeeEntity.getUsername())
                     .addParameter(EmployeeMapper.PASSWORD.getField(), employeeEntity.getPassword())) {

            int affectedRows = query.executeUpdate().getResult();
            if (affectedRows > 0) {
                Long id = ((BigInteger) connection.createQuery("SELECT LAST_INSERT_ID()").executeScalar()).longValueExact();

                employeeEntity.setId(id);
            }
        } catch (Sql2oException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(EmployeeEntity employeeEntity) {

        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(EmployeeRepositoryConstants.UPDATE)) {
                query
                        .addParameter(EmployeeMapper.ID.getField(), employeeEntity.getId())
                        .addParameter(EmployeeMapper.FIRST_NAME.getField(), employeeEntity.getFirstName())
                        .addParameter(EmployeeMapper.LAST_NAME.getField(), employeeEntity.getLastName())
                        .addParameter(EmployeeMapper.GENDER.getField(), employeeEntity.getGender())
                        .addParameter(EmployeeMapper.AGE.getField(), employeeEntity.getAge())
                        .addParameter(EmployeeMapper.EMAIL.getField(), employeeEntity.getEmail())
                        .addParameter(EmployeeMapper.USERNAME.getField(), employeeEntity.getUsername())
                        .addParameter(EmployeeMapper.PASSWORD.getField(), employeeEntity.getPassword())
                        .executeUpdate();
        } catch (Sql2oException e) {
            e.printStackTrace();
        }
    }


    @Override
    public EmployeeEntity findEmployeeById(Long employeeId) {

        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(EmployeeRepositoryConstants.FIND_BY_ID)) {
            query
                    .addParameter(EmployeeMapper.ID.getField(), employeeId)
                    .setColumnMappings(EmployeeMapper.getColumnFieldMappings());
            return query.executeAndFetchFirst(EmployeeEntity.class);
        } catch (Sql2oException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public EmployeeEntity findEmployeeByUsername(String username) {
        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(EmployeeRepositoryConstants.FIND_BY_USERNAME)) {
            query
                    .addParameter(EmployeeMapper.USERNAME.getField(), username)
                    .setColumnMappings(EmployeeMapper.getColumnFieldMappings());
            return query.executeAndFetchFirst(EmployeeEntity.class);
        } catch (Sql2oException e) {
            e.printStackTrace();
            return null;
        }
    }
}
