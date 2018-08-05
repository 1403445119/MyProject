package com.yhren.Dao.Interface;

import com.yhren.Dao.Bean.CompanyBasic;
import java.util.List;

public interface CompanyBasicMapper {
    int deleteByPrimaryKey(Integer companyId);

    int insert(CompanyBasic record);

    CompanyBasic selectByPrimaryKey(Integer companyId);

    List<CompanyBasic> selectAll();

    int updateByPrimaryKey(CompanyBasic record);
}