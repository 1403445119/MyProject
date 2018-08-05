package com.yhren.Dao.Interface;

import com.yhren.Dao.Bean.MaterialsBasic;
import java.util.List;

public interface MaterialsBasicMapper {
    int deleteByPrimaryKey(Integer matId);

    int insert(MaterialsBasic record);

    MaterialsBasic selectByPrimaryKey(Integer matId);

    List<MaterialsBasic> selectAll();

    int updateByPrimaryKey(MaterialsBasic record);
}