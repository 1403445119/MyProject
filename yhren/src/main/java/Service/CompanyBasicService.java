package Service;

import Dao.Entity.Bean.CompanyBasic;
import Dao.Interface.CompanyBasicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CompanyBasicService {

    @Autowired
    CompanyBasicMapper companyBasicMapper;

    public CompanyBasic selectById(int id){
        CompanyBasic companyBasic = companyBasicMapper.selectById(id);
        return companyBasic;
    }

    public boolean update(CompanyBasic companyBasic){
        Date Time = new Date();
        SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd");
        companyBasic.setCompanyCreateTime(matter.format(Time).toString());  //修改时间
        int count = companyBasicMapper.update(companyBasic);
        if(count==1){
            return true;
        }else return false;
    }

    public List<CompanyBasic> selectByName(String name){
        return companyBasicMapper.selectByName(name);
    }

    public boolean insert(CompanyBasic companyBasic){
        List<CompanyBasic> list = companyBasicMapper.selectByName(companyBasic.getCompanyName());
        for(CompanyBasic c : list){
            if(c.getCompanyName().equals(companyBasic.getCompanyName())
                    && c.getCompanyContacts().equals(companyBasic.getCompanyContacts())
                    && c.getCompanyTel().equals(companyBasic.getCompanyTel())){
                return false;
            }
        }
        Date Time = new Date();
        SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd");
        companyBasic.setCompanyCreateTime(matter.format(Time).toString());
        companyBasicMapper.insert(companyBasic);
        return true;
    }

    public boolean delete(int id){
        int i = companyBasicMapper.delete(id);
        return i==1?true:false;
    }
}
