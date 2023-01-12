
package dao;

import entity.Development;
import entity.Other;
import entity.Textbook;

import java.util.List;

public interface OtherDAO {
    public List<Other> selectByNo(String achiev_no);
    public List<Other> selectByNoMentor(String achiev_no, String me_id);
    public Integer insert(Other other);
}