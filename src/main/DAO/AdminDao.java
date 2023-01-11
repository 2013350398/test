package main.DAO;

import main.pojo.Admin;
import java.util.List;

//研究生培养管理员
public interface AdminDao {
    void addAdmin(Admin admin);
    void updateAdmin(Admin admin);
    void deleteAdmin(String ad_id);
    Admin getAdmin(String ad_id);
    List<Admin> findAdmins(Admin admin);
}
