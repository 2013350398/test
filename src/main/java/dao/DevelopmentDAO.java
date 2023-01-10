
package dao;

import entity.Development;
import entity.Patent;

import java.util.List;

public interface DevelopmentDAO {
    public List<Development> selectByNo(String achiev_no);
    public Integer insert(Development development);
}