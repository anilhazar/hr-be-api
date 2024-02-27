package com.spring.repository.impl;

import com.spring.model.entity.LeaveRequestEntity;
import com.spring.repository.LeaveRequestRepository;
import com.spring.repository.mapping.LeaveRequestMapper;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.UUID;

@Repository
public class LeaveRequestRepositoryImply implements LeaveRequestRepository {

    private final Sql2o sql2o;

    public LeaveRequestRepositoryImply(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public LeaveRequestEntity save(LeaveRequestEntity leaveRequestEntity) {
        Connection connection = sql2o.open();
       // leaveRequestEntity.setId(UUID.randomUUID().toString());
        Query query = connection.createQuery(LeaveRequestRepositoryConstants.SAVE);
                query.addParameter("requestType", leaveRequestEntity.getRequestType());
                query.addParameter("status", leaveRequestEntity.getStatus());
                query.addParameter("createDate", leaveRequestEntity.getCreateDate());
                query.addParameter("startDate", leaveRequestEntity.getStartDate());
                query.addParameter("endDate", leaveRequestEntity.getEndDate());
                query.addParameter("employeeId", leaveRequestEntity.getEmployeeId());
                query.executeUpdate();
            return  leaveRequestEntity;

    }

    public LeaveRequestEntity findLeaveRequestsById(Long id){
        Connection connection = sql2o.open();
        Query query = connection.createQuery(LeaveRequestRepositoryConstants.FIND_BY_ID);
        query.addParameter("id", id);
        query.setColumnMappings(LeaveRequestMapper.getColumnFieldMMappings());
        return query.executeAndFetchFirst(LeaveRequestEntity.class);
    }

    @Override
    public List<LeaveRequestEntity> list(Long id) {
        Connection connection = sql2o.open();
        Query query = connection.createQuery(LeaveRequestRepositoryConstants.LIST);
        query.addParameter("id", id);
        query.setColumnMappings(LeaveRequestMapper.getColumnFieldMMappings());
        return  query.executeAndFetch(LeaveRequestEntity.class);
    }
}
