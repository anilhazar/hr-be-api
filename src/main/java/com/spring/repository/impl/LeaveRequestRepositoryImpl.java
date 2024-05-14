package com.spring.repository.impl;

import com.spring.model.entity.LeaveRequestEntity;
import com.spring.repository.LeaveRequestRepository;
import com.spring.repository.mapping.LeaveRequestMapper;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Optional;

@Repository
class LeaveRequestRepositoryImpl implements LeaveRequestRepository {

    private final Sql2o sql2o;

    public LeaveRequestRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void save(LeaveRequestEntity leaveRequestEntity) {

        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(LeaveRequestRepositoryConstants.SAVE)) {
            query
                    .addParameter(LeaveRequestMapper.REQUEST_TYPE.getField(), leaveRequestEntity.getRequestType())
                    .addParameter(LeaveRequestMapper.STATUS.getField(), leaveRequestEntity.getStatus())
                    .addParameter(LeaveRequestMapper.CREATE_DATE.getField(), leaveRequestEntity.getCreateDate())
                    .addParameter(LeaveRequestMapper.START_DATE.getField(), leaveRequestEntity.getStartDate())
                    .addParameter(LeaveRequestMapper.END_DATE.getField(), leaveRequestEntity.getEndDate())
                    .addParameter(LeaveRequestMapper.EMPLOYEE_ID.getField(), leaveRequestEntity.getEmployeeId())
                    .executeUpdate();

        } catch (Sql2oException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(LeaveRequestEntity leaveRequestEntity) {

        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(LeaveRequestRepositoryConstants.UPDATE_BY_ID)) {
            query
                    .addParameter(LeaveRequestMapper.REQUEST_TYPE.getField(), leaveRequestEntity.getRequestType())
                    .addParameter(LeaveRequestMapper.STATUS.getField(), leaveRequestEntity.getStatus())
                    .addParameter(LeaveRequestMapper.CREATE_DATE.getField(), leaveRequestEntity.getCreateDate())
                    .addParameter(LeaveRequestMapper.START_DATE.getField(), leaveRequestEntity.getStartDate())
                    .addParameter(LeaveRequestMapper.END_DATE.getField(), leaveRequestEntity.getEndDate())
                    .addParameter(LeaveRequestMapper.EMPLOYEE_ID.getField(), leaveRequestEntity.getEmployeeId())
                    .executeAndFetchFirst(LeaveRequestEntity.class);

        } catch (Sql2oException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<LeaveRequestEntity> findById(Long id) {
        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(LeaveRequestRepositoryConstants.FIND_BY_ID)) {
            return Optional.ofNullable(query
                    .addParameter(LeaveRequestMapper.ID.getField(), id)
                    .setColumnMappings(LeaveRequestMapper.getColumnFieldMMappings()).
                    executeAndFetchFirst(LeaveRequestEntity.class));

        } catch (Sql2oException e) {

            e.printStackTrace();
            return Optional.empty();

        }

    }

    @Override
    public Optional<List<LeaveRequestEntity>> findAllById(Long employeeId) {

        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(LeaveRequestRepositoryConstants.FIND_BY_EMPLOYEE)) {

            return Optional.ofNullable(query
                    .addParameter(LeaveRequestMapper.EMPLOYEE_ID.getField(), employeeId)
                    .setColumnMappings(LeaveRequestMapper.getColumnFieldMMappings())
                    .executeAndFetch(LeaveRequestEntity.class));

        } catch (Sql2oException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<LeaveRequestEntity>> findLeavesByTodayDate() {

        try (Connection connection = sql2o.open();
             Query query = connection.createQuery(LeaveRequestRepositoryConstants.FIND_BY_DATE)) {

            return Optional.ofNullable(query
                    .setColumnMappings(LeaveRequestMapper.getColumnFieldMMappings())
                    .executeAndFetch(LeaveRequestEntity.class));

        } catch (Sql2oException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
