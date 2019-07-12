package xpu.edu.entry;

import lombok.Data;

@Data
public class GrantItem {
    //序号
    private Integer grant_id;
    //档案编码
    private String salary_id;
    //用户
    private String user_id;
    //薪酬单编号
    private String payment_item_id;
}
