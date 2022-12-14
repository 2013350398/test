package main.DAO.Impl;

import main.DAO.Project_leaderDao;
import main.Util.DBUtil;
import main.Util.DruidUtil;
import main.pojo.Project_leader;
import main.pojo.Project_leader;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Project_leaderDaoImpl implements Project_leaderDao {
    @Override
    public void addProject_leader(Project_leader project_leader) {
        String sql = "INSERT INTO project_leader(pl_id,pl_name,pl_pwd,pl_sex,pl_tel,pl_email) VALUES(?,?,?,?,?,?) ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, project_leader.getPl_id());
            psmt.setString(2, project_leader.getPl_name());
            psmt.setString(3, project_leader.getPl_pwd());
            psmt.setString(4, project_leader.getPl_sex());
            psmt.setString(5, project_leader.getPl_tel());
            psmt.setString(6, project_leader.getPl_email());
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
    public void updateProject_leader(Project_leader project_leader) {
        String sql = "update project_leader set pl_name=?,pl_pwd=?,pl_sex=?,pl_email=?,pl_tel=? where pl_id=? ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, project_leader.getPl_name());
            psmt.setString(2, project_leader.getPl_pwd());
            psmt.setString(3, project_leader.getPl_sex());
            psmt.setString(4, project_leader.getPl_email());
            psmt.setString(5, project_leader.getPl_tel());
            psmt.setString(6, project_leader.getPl_id());
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
    public void deleteProject_leader(String pl_id) {
        String sql = "delete from project_leader where pl_id=?";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, pl_id);
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
    public Project_leader getProject_leader(String pl_id) {
        String sql = "SELECT * FROM project_leader WHERE pl_id=?";
        Connection con = null;
        Project_leader project_leader = new Project_leader();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, pl_id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                project_leader.setPl_id(rs.getString("pl_id"));
                project_leader.setPl_name(rs.getString("pl_name"));
                project_leader.setPl_pwd(rs.getString("pl_pwd"));
                project_leader.setPl_sex(rs.getString("pl_sex"));
                project_leader.setPl_tel(rs.getString("pl_tel"));
                project_leader.setPl_email(rs.getString("pl_email"));
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
        return project_leader;
    }

    @Override
    public List<Project_leader> findProject_leaders(Project_leader project_leader) {
        String sql = "SELECT * FROM project_leader where ";
        Connection con = null;
        List<Project_leader>ad=new ArrayList<>();
        //保存字符串
        StringBuilder suf = new StringBuilder(512);
        suf.append(sql);
        //模糊处理
        if(project_leader.getPl_id() != null){ suf.append("pl_id LIKE '%"+ DBUtil.fixSqlFieldValue(project_leader.getPl_id())+ "%' AND "); }
        if(project_leader.getPl_name() != null){ suf.append("pl_name LIKE '%"+ DBUtil.fixSqlFieldValue(project_leader.getPl_name())+ "%' AND "); }
        if(project_leader.getPl_pwd() != null){ suf.append("pl_pwd LIKE '%"+ DBUtil.fixSqlFieldValue(project_leader.getPl_pwd())+ "%' AND "); }
        if(project_leader.getPl_sex() != null){ suf.append("pl_sex LIKE '%"+ DBUtil.fixSqlFieldValue(project_leader.getPl_sex())+ "%' AND "); }
        if(project_leader.getPl_tel() != null){ suf.append("pl_tel LIKE '%"+ DBUtil.fixSqlFieldValue(project_leader.getPl_tel())+ "%' AND "); }
        if(project_leader.getPl_email() != null){ suf.append("pl_email LIKE '%"+ DBUtil.fixSqlFieldValue(project_leader.getPl_email())+ "%' AND "); }
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
                Project_leader admintemp = new Project_leader();//每次都要new新的对象 list遍历不然会重复同一个
                admintemp.setPl_id(rs.getString("pl_id"));
                admintemp.setPl_name(rs.getString("pl_name"));
                admintemp.setPl_pwd(rs.getString("pl_pwd"));
                admintemp.setPl_sex(rs.getString("pl_sex"));
                admintemp.setPl_tel(rs.getString("pl_tel"));;
                admintemp.setPl_email(rs.getString("pl_email"));
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
