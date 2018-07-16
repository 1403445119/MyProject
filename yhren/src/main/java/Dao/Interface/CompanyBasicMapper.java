package Dao.Interface;

import Dao.Entity.Bean.CompanyBasic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyBasicMapper {

    public CompanyBasic selectById(@Param("id") int id);

    public List<CompanyBasic> selectByName(@Param("name") String name);

    public void insert(@Param("company") CompanyBasic companyBasic);

    public int delete(@Param("id") int id);

    public int update(@Param("entity") CompanyBasic companyBasic);
}
