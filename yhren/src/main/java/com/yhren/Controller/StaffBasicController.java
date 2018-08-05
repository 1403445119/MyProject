package com.yhren.Controller;

import com.yhren.Util.Return;
import com.yhren.Util.Vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yhren.Controller.Basis.Url.*;

@RestController
@RequestMapping(value = STAFF_BASIC)
public class StaffBasicController {

    @Autowired
    StaffBasicService staffBasicService;

    /**
     * 分页查询所有员工
     * @return
     */
    @RequestMapping(value = "/select_all", method = RequestMethod.POST)
    public Return<PageInfo> selectAll(@RequestBody Page page){
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<StaffBasic> list = staffBasicService.selectAll();
        PageInfo<StaffBasic> pageInfo = new PageInfo<>(list);
        return Return.success(pageInfo);
    }

    /**
     * 添加员工
     * @param staffBasic
     * @return
     */
    @RequestMapping(value = "/staff_basic_insert", method = RequestMethod.POST)
    public Return<String> insert(@RequestBody StaffBasic staffBasic){
        staffBasicService.insert(staffBasic);
        return Return.success();
    }

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    @RequestMapping(value = "/select_by_name", method = RequestMethod.POST)
    public Return<PageInfo> selectByName(@RequestParam("name") String name,@RequestBody Page page){
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<StaffBasic> list = staffBasicService.selctByName(name);
        PageInfo<StaffBasic> pageInfo = new PageInfo<>(list);
        return Return.success(pageInfo);
    }

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @RequestMapping("/select_by_id")
    public Return<StaffBasic> selectById(int id){
        StaffBasic staffBasic = staffBasicService.selctById(id);
        return Return.success(staffBasic);
    }
}
