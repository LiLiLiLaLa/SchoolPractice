package xpu.edu.entry;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SalaryInfo {
    //档案编码
    private String salary_id;
    //基本工资
    private BigDecimal salary_basic;
    //绩效奖金
    private BigDecimal salary_bonus;
    //交通
    private BigDecimal salary_traffic;
    //通讯
    private BigDecimal salary_msg;
    //餐补
    private BigDecimal salary_meal;
    //房补
    private BigDecimal salary_housing;
    //出差
    private BigDecimal salary_evection;
    //加班
    private BigDecimal salary_work;
    //薪酬标准名称
    private String salary_name;
    //制定人
    private String salary_creator;
    //登记人
    private String salary_checker;
    //登记时间
    private Date create_time;
    //审核状态
    private Integer salary_status;
    //审核意见
    private String salary_mind;
    //变更原因
    private String salary_change;
}
