package Service;

import Dao.Entity.Bean.StaffBasic;
import Dao.Interface.StaffBasicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffBasicService {
    @Autowired
    StaffBasicMapper staffBasicMapper;

    public List<StaffBasic> selectAll(){
        return staffBasicMapper.selectAllStaffBasic();
    }

    public void insert(StaffBasic staffBasic){
        staffBasicMapper.insertStaffBasic(staffBasic);
    }

    public List<StaffBasic> selctByName(String name){
        return staffBasicMapper.selectStaffByName(name);
    }

    public StaffBasic selctById(int id){
        return staffBasicMapper.selectStaffById(id);
    }
}
