
package dao;

import entity.Award;
import entity.Textbook;
import entity.Thesis;

import java.util.List;

public interface AwardDAO {
    public List<Award> selectByNo(String achiev_no);
    public List<Award> selectByNoMentor(String achiev_no, String me_id);
    public Integer insert(Award award);
}