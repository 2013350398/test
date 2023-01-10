
package dao;

import entity.Award;
import entity.Thesis;

import java.util.List;

public interface AwardDAO {
    public List<Award> selectByNo(String achiev_no);
    public Integer insert(Award award);
}