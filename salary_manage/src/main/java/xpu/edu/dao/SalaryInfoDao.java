package xpu.edu.dao;

import xpu.edu.entry.GrantItem;
import xpu.edu.entry.SalaryInfo;

import java.util.List;

public interface SalaryInfoDao {

    List<SalaryInfo> getAll();

    void addOne(SalaryInfo salaryInfo);

    void deleteOne(String salary_id);

    void updateOne(SalaryInfo salaryInfo);
}
