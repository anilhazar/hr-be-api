package com.spring.repository.impl;

import com.spring.model.entity.LeaveRequestEntity;
import com.spring.repository.LeaveRequestRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

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
}
