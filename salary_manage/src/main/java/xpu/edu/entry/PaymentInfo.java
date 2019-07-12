package xpu.edu.entry;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PaymentInfo {
    //
    private String payment_id;
    //薪酬次数
    private Integer payment_count;
    //总人数
    private String payment_people;
    //总金额
    private BigDecimal payment_money;
    //实发金额
    private BigDecimal payment_real_money;
    //发放时间
    private Date create_time;
}
