
package dao;

import entity.Patent;
import entity.Thesis;

import java.util.List;

public interface PatentDAO {

    public List<Patent> selectByNo(String achiev_no);
    public Integer insert(Patent patent);
}