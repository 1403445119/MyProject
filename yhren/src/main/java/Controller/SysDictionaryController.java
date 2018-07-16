package Controller;

import Dao.Entity.Bean.SysDictionary;
import Service.SysDictionaryService;
import Util.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static Controller.Basis.Url.SYS_DICTIONARY;

@RestController
@RequestMapping(value = SYS_DICTIONARY)
public class SysDictionaryController {

    @Autowired
    SysDictionaryService sysDictionaryService;

    @RequestMapping(value = "/select_by_type", method = RequestMethod.GET)
    public Return<List<SysDictionary>> selectByType(@RequestParam("type") Integer type){
        List<SysDictionary> list = sysDictionaryService.selectByType(type);
        return Return.success(list);
    }
}
