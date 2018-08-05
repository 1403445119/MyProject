package com.yhren.Controller;


import com.yhren.Controller.Basis.Message;
import com.yhren.Dao.Bean.CompanyBasic;
import com.yhren.Util.Return;
import com.yhren.Util.Verification.Verify;
import com.yhren.Util.Vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.yhren.Controller.Basis.Url.*;


@RestController
@RequestMapping(value = COMPANY_BASIC)
class CompanyBasicController {

    @Autowired
    CompanyBasicService companyBasicService;

    /**
     * 分页-根据名字查询商家
     * @param page
     * @param name
     * @return
     */
    @RequestMapping(value = "/select_by_name", method = RequestMethod.POST)
    public Return<PageInfo> selectAll(@RequestBody Page page, @RequestParam("name") String name){
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<CompanyBasic> list = companyBasicService.selectByName(name);
        PageInfo<CompanyBasic> pageInfo = new PageInfo<CompanyBasic>(list);
        return Return.success(pageInfo);
    }

    /**
     * 添加商家
     * @param companyBasic
     * @return
     */
    @RequestMapping(value = "/company_insert", method = RequestMethod.POST)
    public Return insertCompany(@RequestBody CompanyBasic companyBasic){
        String ret  = Verify.verify(companyBasic);
        if (ret.equals("")) {
            return companyBasicService.insert(companyBasic)?Return.template(Message.isSuccess):Return.template(Message.isRepetition);
        }else{
            return Return.erro(ret);
        }
    }

    /**
     * 根据id查询单个商家
     * @param id
     * @return
     */
    @RequestMapping(value = "/select_by_id", method = RequestMethod.GET)
    public Return selectById(@RequestParam("id")int id){
        CompanyBasic companyBasic = companyBasicService.selectById(id);
        return companyBasic==null?Return.template(Message.isReturnNull):Return.success(companyBasic);
    }

    /**
     * 根据id修改商家
     * @param companyBasic
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Return update(@RequestBody CompanyBasic companyBasic){
        return companyBasicService.update(companyBasic)?Return.template(Message.isSuccess):Return.template(Message.isError);
    }

    /**
     * 删除商家
     * @param id
     * @return
     */
    @RequestMapping(value = "/company_delete", method = RequestMethod.GET)
    public Return deleteCompany(@RequestParam("id") int id){
        boolean pass = companyBasicService.delete(id);
        return Return.template(Message.judgeBoolean(pass));
    }

}
