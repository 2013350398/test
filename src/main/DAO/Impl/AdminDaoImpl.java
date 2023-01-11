package main.DAO.Impl;

import main.DAO.AdminDao;
import main.Util.DBUtil;
import main.Util.DruidUtil;
import main.pojo.Admin;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//研究生培养管理员
public class AdminDaoImpl implements AdminDao {

    @Override
    public void addAdmin(Admin admin) {
        String sql = "INSERT INTO admin(ad_id,ad_name,ad_pwd,ad_sex,ad_tel,ad_email) VALUES(?,?,?,?,?,?) ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, admin.getAd_id());
            psmt.setString(2, admin.getAd_name());
            psmt.setString(3, admin.getAd_pwd());
            psmt.setString(4, admin.getAd_sex());
            psmt.setString(5, admin.getAd_tel());
            psmt.setString(6, admin.getAd_email());
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
        String sql = "update admin set ad_name=?,ad_pwd=?,ad_sex=?,ad_email=?,ad_tel=? where ad_id=? ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, admin.getAd_name());
            psmt.setString(2, admin.getAd_pwd());
            psmt.setString(3, admin.getAd_sex());
            psmt.setString(4, admin.getAd_email());
            psmt.setString(5, admin.getAd_tel());
            psmt.setString(6, admin.getAd_id());
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
    public void deleteAdmin(String ad_id) {
        String sql = "delete from admin where ad_id=?";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, ad_id);
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
    public Admin getAdmin(String ad_id) {
        String sql = "SELECT * FROM admin WHERE ad_id=?";
        Connection con = null;
        Admin admin = new Admin();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, ad_id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                admin.setAd_id(rs.getString("ad_id"));
                admin.setAd_name(rs.getString("ad_name"));
                admin.setAd_pwd(rs.getString("ad_pwd"));
                admin.setAd_sex(rs.getString("ad_sex"));
                admin.setAd_tel(rs.getString("ad_tel"));
                admin.setAd_email(rs.getString("ad_email"));
            }
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
        return admin;
    }

    @Override
    public List<Admin> findAdmins(Admin admin) {
        String sql = "SELECT * FROM admin where ";
        Connection con = null;
        List<Admin>ad=new ArrayList<>();
        //保存字符串
        StringBuilder suf = new StringBuilder(512);
        suf.append(sql);
        //模糊处理
        if(admin.getAd_id() != null){ suf.append("ad_id LIKE '%"+ DBUtil.fixSqlFieldValue(admin.getAd_id())+ "%' AND "); }
        if(admin.getAd_name() != null){ suf.append("ad_name LIKE '%"+ DBUtil.fixSqlFieldValue(admin.getAd_name())+ "%' AND "); }
        if(admin.getAd_pwd() != null){ suf.append("ad_pwd LIKE '%"+ DBUtil.fixSqlFieldValue(admin.getAd_pwd())+ "%' AND "); }
        if(admin.getAd_sex() != null){ suf.append("ad_sex LIKE '%"+ DBUtil.fixSqlFieldValue(admin.getAd_sex())+ "%' AND "); }
        if(admin.getAd_tel() != null){ suf.append("ad_tel LIKE '%"+ DBUtil.fixSqlFieldValue(admin.getAd_tel())+ "%' AND "); }
        if(admin.getAd_email() != null){ suf.append("ad_email LIKE '%"+ DBUtil.fixSqlFieldValue(admin.getAd_email())+ "%' AND "); }
        //删除无用and where 前后空格也要删除
        if(suf.substring(suf.length()-5).equals(" AND ")){suf.delete(suf.length()-5,suf.length()-1);}
        if(suf.substring(suf.length()-7).equals(" WHERE ")){suf.delete(suf.length()-7,suf.length()-1);}
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(suf.toString());//
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                Admin admintemp = new Admin();//每次都要new新的对象 list遍历不然会重复同一个
                admintemp.setAd_id(rs.getString("ad_id"));
                admintemp.setAd_name(rs.getString("ad_name"));
                admintemp.setAd_pwd(rs.getString("ad_pwd"));
                admintemp.setAd_sex(rs.getString("ad_sex"));
                admintemp.setAd_tel(rs.getString("ad_tel"));;
                admintemp.setAd_email(rs.getString("ad_email"));
                ad.add(admintemp);
            }
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
        return ad;
    }
}
