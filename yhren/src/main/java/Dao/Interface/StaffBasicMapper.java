package Dao.Interface;
    
import Dao.Entity.Bean.StaffBasic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffBasicMapper {
    public StaffBasic selectStaffById(@Param("id")int id);
    public List<StaffBasic> selectStaffByName(@Param("name")String name);
    public List<StaffBasic> selectAllStaffBasic();
    public void insertStaffBasic(StaffBasic staffBasic);
    public void upDateStaffBasicById(StaffBasic staffBasic);
    public void deleteStaffBasicById(@Param("id")int id);
}
