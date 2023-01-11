package main.DAO.Impl;

import main.DAO.MentorDao;
import main.Util.DBUtil;
import main.Util.DruidUtil;
import main.pojo.Mentor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//学生
public class MentorDaoImpl implements MentorDao {
    @Override
    public void addMentor(Mentor mentor) {
        String sql = "INSERT INTO mentor(me_id,me_name,me_pwd,me_sex,me_tel,me_email) VALUES(?,?,?,?,?,?) ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, mentor.getMe_id());
            psmt.setString(2, mentor.getMe_name());
            psmt.setString(3, mentor.getMe_pwd());
            psmt.setString(4, mentor.getMe_sex());
            psmt.setString(5, mentor.getMe_tel());
            psmt.setString(6, mentor.getMe_email());
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
    public void updateMentor(Mentor mentor) {
        String sql = "update mentor set me_name=?,me_pwd=?,me_sex=?,me_email=?,me_tel=? where me_id=? ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, mentor.getMe_name());
            psmt.setString(2, mentor.getMe_pwd());
            psmt.setString(3, mentor.getMe_sex());
            psmt.setString(4, mentor.getMe_email());
            psmt.setString(5, mentor.getMe_tel());
            psmt.setString(6, mentor.getMe_id());
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
    public void deleteMentor(String me_id) {
        String sql = "delete from mentor where me_id=?";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, me_id);
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
    public Mentor getMentor(String me_id) {
        String sql = "SELECT * FROM mentor WHERE me_id=?";
        Connection con = null;
        Mentor mentor = new Mentor();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, me_id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                mentor.setMe_id(rs.getString("me_id"));
                mentor.setMe_name(rs.getString("me_name"));
                mentor.setMe_pwd(rs.getString("me_pwd"));
                mentor.setMe_sex(rs.getString("me_sex"));
                mentor.setMe_tel(rs.getString("me_tel"));
                mentor.setMe_email(rs.getString("me_email"));
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
        return mentor;
    }

    @Override
    public List<Mentor> findMentors(Mentor mentor) {
        String sql = "SELECT * FROM mentor where ";
        Connection con = null;
        List<Mentor>st=new ArrayList<>();
        //保存字符串
        StringBuilder suf = new StringBuilder(512);
        suf.append(sql);
        //模糊处理
        if(mentor.getMe_id() != null){ suf.append("me_id LIKE '%"+ DBUtil.fixSqlFieldValue(mentor.getMe_id())+ "%' AND "); }
        if(mentor.getMe_name() != null){ suf.append("me_name LIKE '%"+ DBUtil.fixSqlFieldValue(mentor.getMe_name())+ "%' AND "); }
        if(mentor.getMe_pwd() != null){ suf.append("me_pwd LIKE '%"+ DBUtil.fixSqlFieldValue(mentor.getMe_pwd())+ "%' AND "); }
        if(mentor.getMe_sex() != null){ suf.append("me_sex LIKE '%"+ DBUtil.fixSqlFieldValue(mentor.getMe_sex())+ "%' AND "); }
        if(mentor.getMe_tel() != null){ suf.append("me_tel LIKE '%"+ DBUtil.fixSqlFieldValue(mentor.getMe_tel())+ "%' AND "); }
        if(mentor.getMe_email() != null){ suf.append("me_email LIKE '%"+ DBUtil.fixSqlFieldValue(mentor.getMe_email())+ "%' AND "); }
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
                Mentor admintemp = new Mentor();//每次都要new新的对象 list遍历不然会重复同一个
                admintemp.setMe_id(rs.getString("me_id"));
                admintemp.setMe_name(rs.getString("me_name"));
                admintemp.setMe_pwd(rs.getString("me_pwd"));
                admintemp.setMe_sex(rs.getString("me_sex"));
                admintemp.setMe_tel(rs.getString("me_tel"));;
                admintemp.setMe_email(rs.getString("me_email"));
                st.add(admintemp);
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
        return st;
    }
}
