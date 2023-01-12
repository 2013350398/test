
package dao;

import entity.Patent;
import entity.Textbook;
import entity.Thesis;

import java.util.List;

public interface PatentDAO {

    public List<Patent> selectByNo(String achiev_no);
    public List<Patent> selectByNoMentor(String achiev_no, String me_id);
    public Integer insert(Patent patent);
}