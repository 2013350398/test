
package dao;

import entity.Standard;
import entity.Thesis;

import java.util.List;

public interface StandardDAO {
    public List<Standard> selectByNo(String achiev_no);
    public Integer insert(Standard standard);
}