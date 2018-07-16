package Dao.Interface;

import Dao.Entity.Bean.SysDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictionaryMapper {

    //List<SysDictionary> selectById(@Param("id") Integer id);

    public List<SysDictionary> selectByType(@Param("type") Integer type);
}
