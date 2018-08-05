package com.yhren.Dao.Interface;

import com.yhren.Dao.Bean.LeaseRecord;
import java.util.List;

public interface LeaseRecordMapper {
    int deleteByPrimaryKey(Integer leaseId);

    int insert(LeaseRecord record);

    LeaseRecord selectByPrimaryKey(Integer leaseId);

    List<LeaseRecord> selectAll();

    int updateByPrimaryKey(LeaseRecord record);
}