package main.DAO.Impl;

import main.DAO.SubjectDao;
import main.Util.DBUtil;
import main.Util.DruidUtil;
import main.pojo.Subject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl implements SubjectDao {
    @Override
    public void addSubject(Subject subject) {
        String sql = "INSERT INTO subject(su_id,su_name) VALUES(?,?) ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, subject.getSu_id());
            psmt.setString(2, subject.getSu_name());
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
    public void updateSubject(Subject subject) {
        String sql = "update subject set su_name=? where su_id=? ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, subject.getSu_name());
            psmt.setString(2, subject.getSu_id());
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
    public void deleteSubject(String su_id) {
        String sql = "delete from subject where su_id=?";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, su_id);
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
    public Subject getSubject(String su_id) {
        String sql = "SELECT * FROM subject WHERE su_id=?";
        Connection con = null;
        Subject subject = new Subject();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, su_id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                subject.setSu_id(rs.getString("su_id"));
                subject.setSu_name(rs.getString("su_name"));
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
        return subject;
    }

    @Override
    public List<Subject> findSubjects(Subject subject) {
        String sql = "SELECT * FROM subject where ";
        Connection con = null;
        List<Subject>ad=new ArrayList<>();
        //保存字符串
        StringBuilder suf = new StringBuilder(512);
        suf.append(sql);
        //模糊处理
        if(subject.getSu_id() != null){ suf.append("su_id LIKE '%"+ DBUtil.fixSqlFieldValue(subject.getSu_id())+ "%' AND "); }
        if(subject.getSu_name() != null){ suf.append("su_name LIKE '%"+ DBUtil.fixSqlFieldValue(subject.getSu_name())+ "%' AND "); }
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
                Subject admintemp = new Subject();//每次都要new新的对象 list遍历不然会重复同一个
                admintemp.setSu_id(rs.getString("su_id"));
                admintemp.setSu_name(rs.getString("su_name"));
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
