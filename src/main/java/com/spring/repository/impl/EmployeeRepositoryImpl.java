package com.spring.repository.impl;

import com.spring.model.entity.EmployeeEntity;
import com.spring.repository.EmployeeRepository;
import com.spring.repository.mapping.EmployeeMapper;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Optional;

@Repository
class EmployeeRepositoryImpl implements EmployeeRepository {
    private final Sql2o sql2o;

    public EmployeeRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void save(EmployeeEntity employeeEntity) {

        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(EmployeeRepositoryConstants.SAVE, true)) {
            query

                    .addParameter(EmployeeMapper.FIRST_NAME.getField(), employeeEntity.getfirstName())
                    .addParameter(EmployeeMapper.LAST_NAME.getField(), employeeEntity.getLastName())
                    .addParameter(EmployeeMapper.GENDER.getField(), employeeEntity.getGender())
                    .addParameter(EmployeeMapper.BIRTHDAY.getField(), employeeEntity.getBirthday())
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
    public void update(EmployeeEntity employeeEntity) {

        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(EmployeeRepositoryConstants.UPDATE_BY_ID)) {

            query
                        .addParameter(EmployeeMapper.ID.getField(), employeeEntity.getId())
                    .addParameter(EmployeeMapper.FIRST_NAME.getField(), employeeEntity.getfirstName())
                        .addParameter(EmployeeMapper.LAST_NAME.getField(), employeeEntity.getLastName())
                        .addParameter(EmployeeMapper.GENDER.getField(), employeeEntity.getGender())
                    .addParameter(EmployeeMapper.BIRTHDAY.getField(), employeeEntity.getBirthday())
                        .addParameter(EmployeeMapper.AGE.getField(), employeeEntity.getAge())
                        .addParameter(EmployeeMapper.EMAIL.getField(), employeeEntity.getEmail())
                        .addParameter(EmployeeMapper.USERNAME.getField(), employeeEntity.getUsername())
                        .addParameter(EmployeeMapper.PASSWORD.getField(), employeeEntity.getPassword())
                    .executeAndFetchFirst(EmployeeEntity.class);
        } catch (Sql2oException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmployeeEntity> findAllEmployee() {

        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(EmployeeRepositoryConstants.FIND_ALL)) {

            return query.executeAndFetch(EmployeeEntity.class);
        } catch (Sql2oException sql2oException) {
            sql2oException.printStackTrace();
            return List.of();
        }
    }

    @Override
    public Optional<EmployeeEntity> findEmployeeById(Long id) {

        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(EmployeeRepositoryConstants.FIND_BY_ID)) {

            return Optional.ofNullable(query
                    .addParameter(EmployeeMapper.ID.getField(), id)
                    .setColumnMappings(EmployeeMapper.getColumnFieldMappings())
                    .executeAndFetchFirst(EmployeeEntity.class));
        } catch (Sql2oException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<EmployeeEntity> findEmployeeByUsername(String username) {
        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(EmployeeRepositoryConstants.FIND_BY_USERNAME)) {

            return Optional.ofNullable(query
                    .addParameter(EmployeeMapper.USERNAME.getField(), username)
                    .setColumnMappings(EmployeeMapper.getColumnFieldMappings())
                    .executeAndFetchFirst(EmployeeEntity.class));
        } catch (Sql2oException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
