
package dao;

import entity.Award;
import entity.Report;

import java.util.List;

public interface ReportDAO {
    public List<Report> selectByNo(String achiev_no);
    public Integer insert(Report report);
}