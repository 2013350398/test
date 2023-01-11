package main.DAO.Impl;

import main.DAO.ProjectDao;
import main.Util.DBUtil;
import main.Util.DruidUtil;
import main.pojo.Project;
import main.pojo.Project;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {
    @Override
    public void addProject(Project project) {
        String sql = "INSERT INTO project(pr_id,pr_name,pr_type,pl_id,me_id) VALUES(?,?,?,?,?) ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, project.getPr_id());
            psmt.setString(2, project.getPr_name());
            psmt.setString(3, project.getPr_type());
            psmt.setString(4, project.getPl_id());
            psmt.setString(5, project.getMe_id());
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
    public void updateProject(Project project) {
        String sql = "update project set pr_name=?,pr_type=?,me_id=?,pl_id=? where pr_id=? ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, project.getPr_name());
            psmt.setString(2, project.getPr_type());
            psmt.setString(3, project.getMe_id());
            psmt.setString(4, project.getPl_id());
            psmt.setString(5, project.getPr_id());
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
    public void deleteProject(String pr_id) {
        String sql = "delete from project where pr_id=?";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, pr_id);
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
    public Project getProject(String pr_id) {
        String sql = "SELECT * FROM project WHERE pr_id=?";
        Connection con = null;
        Project project = new Project();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, pr_id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                project.setPr_id(rs.getString("pr_id"));
                project.setPr_name(rs.getString("pr_name"));
                project.setPr_type(rs.getString("pr_type"));
                project.setPl_id(rs.getString("pl_id"));
                project.setMe_id(rs.getString("me_id"));
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
        return project;
    }

    @Override
    public List<Project> findProjects(Project project) {
        String sql = "SELECT * FROM project where ";
        Connection con = null;
        List<Project>pr=new ArrayList<>();
        //保存字符串
        StringBuilder suf = new StringBuilder(512);
        suf.append(sql);
        //模糊处理
        if(project.getPr_id() != null){ suf.append("pr_id LIKE '%"+ DBUtil.fixSqlFieldValue(project.getPr_id())+ "%' AND "); }
        if(project.getPr_name() != null){ suf.append("pr_name LIKE '%"+ DBUtil.fixSqlFieldValue(project.getPr_name())+ "%' AND "); }
        if(project.getPr_type() != null){ suf.append("pr_type LIKE '%"+ DBUtil.fixSqlFieldValue(project.getPr_type())+ "%' AND "); }
        if(project.getPl_id() != null){ suf.append("pl_id LIKE '%"+ DBUtil.fixSqlFieldValue(project.getPl_id())+ "%' AND "); }
        if(project.getMe_id() != null){ suf.append("me_id LIKE '%"+ DBUtil.fixSqlFieldValue(project.getMe_id())+ "%' AND "); }
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
                Project pitemp = new Project();//每次都要new新的对象 list遍历不然会重复同一个
                pitemp.setPr_id(rs.getString("pr_id"));
                pitemp.setPr_name(rs.getString("pr_name"));
                pitemp.setPr_type(rs.getString("pr_type"));
                pitemp.setPl_id(rs.getString("pl_id"));
                pitemp.setMe_id(rs.getString("me_id"));
                pr.add(pitemp);
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
        return pr;
    }

    @Override
    public List<Project> findProjectsBYPl_id(String pl_id) {
        String sql = "SELECT * FROM project where pl_id=?";
        Connection con = null;
        List<Project>pr=new ArrayList<>();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, pl_id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                Project pitemp = new Project();//每次都要new新的对象 list遍历不然会重复同一个
                pitemp.setPr_id(rs.getString("pr_id"));
                pitemp.setPr_name(rs.getString("pr_name"));
                pitemp.setPr_type(rs.getString("pr_type"));
                pitemp.setPl_id(rs.getString("pl_id"));
                pitemp.setMe_id(rs.getString("me_id"));
                pr.add(pitemp);
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
        return pr;
    }

    @Override
    public List<Project> findProjectsBYMe_id(String me_id) {
        String sql = "SELECT * FROM project where me_id=?";
        Connection con = null;
        List<Project>pr=new ArrayList<>();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, me_id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                Project pitemp = new Project();//每次都要new新的对象 list遍历不然会重复同一个
                pitemp.setPr_id(rs.getString("pr_id"));
                pitemp.setPr_name(rs.getString("pr_name"));
                pitemp.setPr_type(rs.getString("pr_type"));
                pitemp.setPl_id(rs.getString("pl_id"));
                pitemp.setMe_id(rs.getString("me_id"));
                pr.add(pitemp);
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
        return pr;
    }

    @Override
    public List<Project> getAllProject() {
        String sql = "SELECT * FROM project ";
        Connection con = null;
        List<Project>pr=new ArrayList<>();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                Project pitemp = new Project();//每次都要new新的对象 list遍历不然会重复同一个
                pitemp.setPr_id(rs.getString("pr_id"));
                pitemp.setPr_name(rs.getString("pr_name"));
                pitemp.setPr_type(rs.getString("pr_type"));
                pitemp.setPl_id(rs.getString("pl_id"));
                pitemp.setMe_id(rs.getString("me_id"));
                pr.add(pitemp);
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
        return pr;
    }
}
