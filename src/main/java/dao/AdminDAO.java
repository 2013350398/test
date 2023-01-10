package dao;

import entity.Admin;
import entity.Mentor;

import java.util.List;

public interface AdminDAO {
    public List<Admin> selectAll();

    public Admin selectByNo(String ad_no);
    public List<Admin> selectByName(String ad_name);
}
