package Dao.Interface;

import Dao.Entity.Bean.MaterialBasic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MateriablBasicMapper {

    public List<MaterialBasic> selectByName(@Param("name")String name);

    public MaterialBasic selectById(@Param("id")int id);
}
