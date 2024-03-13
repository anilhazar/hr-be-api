package com.spring.repository.impl.leaverequest;

import com.spring.model.entity.LeaveRequestEntity;
import com.spring.repository.LeaveRequestRepository;
import com.spring.repository.mapping.LeaveRequestMapper;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
class LeaveRequestRepositoryImpl implements LeaveRequestRepository {

    private final Sql2o sql2o;
    public LeaveRequestRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void save(LeaveRequestEntity leaveRequestEntity) {

        try (Connection connection = sql2o.open()) {
            try (Query query = connection.createQuery(LeaveRequestRepositoryConstants.SAVE)) {

                query
                        .addParameter(LeaveRequestMapper.REQUEST_TYPE.getField(), leaveRequestEntity.getRequestType())
                        .addParameter(LeaveRequestMapper.STATUS.getField(), leaveRequestEntity.getStatus())
                        .addParameter(LeaveRequestMapper.CREATE_DATE.getField(), leaveRequestEntity.getCreateDate())
                        .addParameter(LeaveRequestMapper.START_DATE.getField(), leaveRequestEntity.getStartDate())
                        .addParameter(LeaveRequestMapper.END_DATE.getField(), leaveRequestEntity.getEndDate())
                        .addParameter(LeaveRequestMapper.EMPLOYEE_ID.getField(), leaveRequestEntity.getEmployeeId())
                        .executeUpdate();
            }
        }
    }

    @Override
    public LeaveRequestEntity findLeaveRequestsById(Long id){

        try (Connection connection = sql2o.open()) {
            try (Query query = connection.createQuery(LeaveRequestRepositoryConstants.FIND_BY_ID)) {

                query
                        .addParameter(LeaveRequestMapper.ID.getField(), id)
                        .setColumnMappings(LeaveRequestMapper.getColumnFieldMMappings());
                return query.executeAndFetchFirst(LeaveRequestEntity.class);
            }
        }
    }

    @Override
    public List<LeaveRequestEntity> list(Long id) {

        try (Connection connection = sql2o.open()) {
            try (Query query = connection.createQuery(LeaveRequestRepositoryConstants.LIST)) {

                query
                        .addParameter(LeaveRequestMapper.EMPLOYEE_ID.getField(), id)
                        .setColumnMappings(LeaveRequestMapper.getColumnFieldMMappings());
                return query.executeAndFetch(LeaveRequestEntity.class);
            }
        }
    }
}
