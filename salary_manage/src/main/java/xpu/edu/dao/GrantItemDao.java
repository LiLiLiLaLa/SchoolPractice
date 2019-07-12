package xpu.edu.dao;

import xpu.edu.entry.GrantItem;

import java.util.List;

public interface GrantItemDao {

    List<GrantItem> getAll();

    void addOne(GrantItem grantItem);

    void deleteOne(Integer grant_id);

    void updateOne(GrantItem grantItem);
}
