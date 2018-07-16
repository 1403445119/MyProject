package Service;

import Dao.Entity.Bean.MaterialBasic;
import Dao.Interface.MateriablBasicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriablBasicService {

    @Autowired
    MateriablBasicMapper materiablBasicMapper;

    public List<MaterialBasic> select(String name){
        return materiablBasicMapper.selectByName(name);
    }

    public MaterialBasic selectById(int id){
        return materiablBasicMapper.selectById(id);
    }
}
