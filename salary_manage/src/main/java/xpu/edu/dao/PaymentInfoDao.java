package xpu.edu.dao;

import xpu.edu.entry.PaymentInfo;

import java.util.List;

public interface PaymentInfoDao {

    List<PaymentInfo> getAll();

    void addOne(PaymentInfo paymentInfo);

    void deleteOne(String payment_id);

    void updateOne(PaymentInfo paymentInfo);
}
