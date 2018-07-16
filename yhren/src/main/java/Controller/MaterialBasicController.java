package Controller;

import Controller.Basis.Message;
import Dao.Entity.Bean.MaterialBasic;
import Service.MateriablBasicService;
import Util.Return;
import Util.Vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static Controller.Basis.Url.MATERIAL_BASIC;

@RestController
@RequestMapping(value = MATERIAL_BASIC)
public class MaterialBasicController {

    @Autowired
    MateriablBasicService materiablBasicService;

    /**
     * 分页--展示以及模糊查询
     * @param page
     * @param name
     * @return
     */
    @RequestMapping(value = "/select_by_name", method = RequestMethod.POST)
    public Return<PageInfo> select(@RequestBody Page page, @RequestParam("name") String name){
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<MaterialBasic> list = materiablBasicService.select(name);
        PageInfo<MaterialBasic> pageInfo = new PageInfo<MaterialBasic>(list);
        return Return.success(pageInfo);
    }

    /**
     * 编辑的时候的查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/select_by_id", method = RequestMethod.GET)
    public Return<MaterialBasic> selectById(@RequestParam("id")int id){
        MaterialBasic materialBasic = materiablBasicService.selectById(id);
        return materialBasic!=null?Return.success(materialBasic):Return.template(Message.isTomcatDeGuo);
    }
}
