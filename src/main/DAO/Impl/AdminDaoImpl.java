package main.DAO.Impl;

import main.DAO.AdminDao;
import main.Util.DruidUtil;
import main.pojo.Admin;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    @Override
    public void addAdmin(Admin admin) {
        String STUDENT_INSERT_SQL = "INSERT INTO admin(ad_id,ad_name,ad_pwd) VALUES(?,?,?) ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(STUDENT_INSERT_SQL);
            psmt.setString(1, admin.getAd_id());
            psmt.setString(2, admin.getAd_name());
            psmt.setString(3, admin.getAd_pwd());
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateAdmin(Admin admin) {

    }

    @Override
    public void deleteAdmin(String admin_no) {

    }

    @Override
    public Admin getAdmin(String admin_no) {
        return null;
    }

    @Override
    public List<Admin> findAdmins(Admin s) {
        return null;
    }
}
