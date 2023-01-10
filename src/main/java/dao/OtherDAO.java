
package dao;

import entity.Development;
import entity.Other;

import java.util.List;

public interface OtherDAO {
    public List<Other> selectByNo(String achiev_no);
    public Integer insert(Other other);
}