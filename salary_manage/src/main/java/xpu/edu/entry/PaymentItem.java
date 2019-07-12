package xpu.edu.entry;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentItem {
    //
    private String payment_item_id;
    //一级机构
    private String payment_item_org;
    //二级机构
    private String payment_item_orgg;
    //人数
    private Integer payment_item_people;
    //基本薪酬金额
    private BigDecimal payment_item_money;
}
