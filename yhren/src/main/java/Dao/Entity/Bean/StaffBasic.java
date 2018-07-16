package Dao.Entity.Bean;

import lombok.Data;

@Data
public class StaffBasic {
    private Integer staffId;    //id
    private String staffName;   //姓名
    private String staffTel;    //电话
    private String staffPath;   //住址
    private Integer staffSalary;    //工资
    private Integer staffAge;   //年龄
    private String staffSex;    //性别
    private Integer staffStatus;    //是否在职 默认1
    private Integer staffCheck; //当日是否签到 默认0
    private String staffRemarks;    //备注
}
