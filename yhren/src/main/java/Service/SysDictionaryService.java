package Service;

import Dao.Entity.Bean.SysDictionary;
import Dao.Interface.SysDictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictionaryService {
    @Autowired
    SysDictionaryMapper sysDictionaryMapper;

    public List<SysDictionary> selectByType(Integer type){
        return sysDictionaryMapper.selectByType(type);
    }
}
