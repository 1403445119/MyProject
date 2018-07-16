package Dao.Entity.Bean;

import Util.Verification.Note;
import lombok.Data;

@Data
public class CompanyBasic {
    private Integer companyId;
    @Note(name="商家名称")
    private String companyName;
    @Note(name="商家地址")
    private String companyPath;
    @Note(name="商家代理人")
    private String companyContacts;
    @Note(name="联系电话",type = 1)
    private String companyTel;
    private Integer companyPass;
    private String companyCreateTime;
}
