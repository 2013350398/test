package main.DAO;

import main.pojo.Admin;

import java.util.List;

public interface AdminDao {
    void addAdmin(Admin admin);
    void updateAdmin(Admin admin);
    void deleteAdmin(String admin_no);
    Admin getAdmin(String admin_no);
    List<Admin> findAdmins(Admin s);
}
