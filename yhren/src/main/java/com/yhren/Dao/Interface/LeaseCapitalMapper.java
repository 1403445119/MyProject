package com.yhren.Dao.Interface;

import com.yhren.Dao.Bean.LeaseCapital;
import java.util.List;

public interface LeaseCapitalMapper {
    int deleteByPrimaryKey(Integer capId);

    int insert(LeaseCapital record);

    LeaseCapital selectByPrimaryKey(Integer capId);

    List<LeaseCapital> selectAll();

    int updateByPrimaryKey(LeaseCapital record);
}