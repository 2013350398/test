package main.DAO.Impl;

import main.DAO.GraduateDao;
import main.Util.DBUtil;
import main.Util.DruidUtil;
import main.pojo.Graduate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GraduateDaoImpl implements GraduateDao {
    @Override
    public void addGraduate(Graduate graduate) {
        String sql = "INSERT INTO graduate(gr_id,st_id,as_num,aca_num,pi_num,ach_num,gr_state) VALUES(?,?,?,?,?,?,?) ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, graduate.getGr_id());
            psmt.setString(2, graduate.getSt_id());
            psmt.setInt(3, graduate.getAs_num());
            psmt.setInt(4, graduate.getAca_num());
            psmt.setInt(5, graduate.getPi_num());
            psmt.setInt(6, graduate.getAch_num());
            psmt.setString(7, graduate.getGr_state());
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
    public void updateGraduate(Graduate graduate) {
        String sql = "update graduate set st_id=?,as_num=?,aca_num=?,pi_num=?,ach_num=?,gr_state=? where gr_id=? ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, graduate.getSt_id());
            psmt.setInt(2, graduate.getAs_num());
            psmt.setInt(3, graduate.getAca_num());
            psmt.setInt(4, graduate.getPi_num());
            psmt.setInt(5, graduate.getAch_num());
            psmt.setString(6, graduate.getGr_state());
            psmt.setString(7, graduate.getGr_id());
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
    public void deleteGraduate(String gr_id) {
        String sql = "delete from graduate where gr_id=?";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, gr_id);
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
    public Graduate getGraduate(String gr_id) {
        String sql = "SELECT * FROM graduate WHERE gr_id=?";
        Connection con = null;
        Graduate graduate = new Graduate();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, gr_id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                graduate.setGr_id(rs.getString("gr_id"));
                graduate.setSt_id(rs.getString("st_id"));
                graduate.setAs_num(rs.getInt("as_num"));
                graduate.setAca_num(rs.getInt("aca_num"));
                graduate.setPi_num(rs.getInt("pi_num"));
                graduate.setAch_num(rs.getInt("ach_num"));
                graduate.setGr_state(rs.getString("gr_state"));
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
        return graduate;
    }

    @Override
    public Graduate getGraduateBySt_id(String st_id) {
        String sql = "SELECT * FROM graduate WHERE st_id=?";
        Connection con = null;
        Graduate graduate = new Graduate();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, st_id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                graduate.setGr_id(rs.getString("gr_id"));
                graduate.setSt_id(rs.getString("st_id"));
                graduate.setAs_num(rs.getInt("as_num"));
                graduate.setAca_num(rs.getInt("aca_num"));
                graduate.setPi_num(rs.getInt("pi_num"));
                graduate.setAch_num(rs.getInt("ach_num"));
                graduate.setGr_state(rs.getString("gr_state"));
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
        return graduate;
    }

    @Override
    public List<Graduate> findGraduates(Graduate graduate) {
        String sql = "SELECT * FROM graduate where ";
        Connection con = null;
        List<Graduate>gr=new ArrayList<>();
        //保存字符串
        StringBuilder suf = new StringBuilder(512);
        suf.append(sql);
        //模糊处理
        if(graduate.getGr_id() != null){ suf.append("gr_id LIKE '%"+ DBUtil.fixSqlFieldValue(graduate.getGr_id())+ "%' AND "); }
        if(graduate.getSt_id() != null){ suf.append("st_id LIKE '%"+ DBUtil.fixSqlFieldValue(graduate.getSt_id())+ "%' AND "); }
        //int模糊匹配有问题：不set进入值就默认0 但是如果set为0 就不会参与匹配（如何解决）
        if(graduate.getAs_num() != 0)suf.append("as_num = "+ graduate.getAs_num()+ " AND ");
        if(graduate.getAca_num() != 0)suf.append("aca_num = "+ graduate.getAca_num()+ " AND ");
        if(graduate.getPi_num() != 0)suf.append("pi_num = "+ graduate.getPi_num()+ " AND ");
        if(graduate.getAch_num() != 0)suf.append("ach_num = "+ graduate.getAch_num()+ " AND ");
        if(graduate.getGr_state() != null){ suf.append("gr_state LIKE '%"+ DBUtil.fixSqlFieldValue(graduate.getGr_state())+ "%' AND "); }
        //删除无用and where 前后空格也要删除
        if(suf.substring(suf.length()-5).equals(" AND ")){suf.delete(suf.length()-5,suf.length()-1);}
        if(suf.substring(suf.length()-7).equals(" WHERE ")){suf.delete(suf.length()-7,suf.length()-1);}
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            System.out.println(suf.toString());
            PreparedStatement psmt = con.prepareStatement(suf.toString());//
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                Graduate graduatetemp = new Graduate();//每次都要new新的对象 list遍历不然会重复同一个
                graduatetemp.setGr_id(rs.getString("gr_id"));
                graduatetemp.setSt_id(rs.getString("st_id"));
                graduatetemp.setAs_num(rs.getInt("as_num"));
                graduatetemp.setAca_num(rs.getInt("aca_num"));
                graduatetemp.setPi_num(rs.getInt("pi_num"));
                graduatetemp.setAch_num(rs.getInt("ach_num"));
                graduatetemp.setGr_state(rs.getString("gr_state"));
                gr.add(graduatetemp);
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
        return gr;
    }

    @Override
    public List<Graduate> getAllGraduates() {
        String sql = "SELECT * FROM graduate";
        Connection con = null;
        List<Graduate>gr=new ArrayList<>();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                Graduate graduate = new Graduate();
                graduate.setGr_id(rs.getString("gr_id"));
                graduate.setSt_id(rs.getString("st_id"));
                graduate.setAs_num(rs.getInt("as_num"));
                graduate.setAca_num(rs.getInt("aca_num"));
                graduate.setPi_num(rs.getInt("pi_num"));
                graduate.setAch_num(rs.getInt("ach_num"));
                graduate.setGr_state(rs.getString("gr_state"));
                gr.add(graduate);
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
        return gr;
    }
}
