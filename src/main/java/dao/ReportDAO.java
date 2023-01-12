
package dao;

import entity.Award;
import entity.Report;
import entity.Textbook;

import java.util.List;

public interface ReportDAO {
    public List<Report> selectByNo(String achiev_no);
    public List<Report> selectByNoMentor(String achiev_no, String me_id);
    public Integer insert(Report report);
}