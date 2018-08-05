package com.yhren.Dao.Interface;

import com.yhren.Dao.Bean.StaffBasic;
import java.util.List;

public interface StaffBasicMapper {
    int deleteByPrimaryKey(Integer staffId);

    int insert(StaffBasic record);

    StaffBasic selectByPrimaryKey(Integer staffId);

    List<StaffBasic> selectAll();

    int updateByPrimaryKey(StaffBasic record);
}