package xpu.edu.dao;

import xpu.edu.entry.GrantItem;
import xpu.edu.entry.PaymentItem;

import java.util.List;

public interface PaymentItemDao {

    List<PaymentItem> getAll();

    void addOne(PaymentItem paymentItem);

    void deleteOne(String payment_item_id);

    void updateOne(PaymentItem paymentItem);
}
