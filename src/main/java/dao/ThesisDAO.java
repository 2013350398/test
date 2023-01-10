
package dao;

import entity.Thesis;

import java.util.List;

public interface ThesisDAO {
    public List<Thesis> selectByNo(String achiev_no);
    public Integer insert(Thesis thesis);
}