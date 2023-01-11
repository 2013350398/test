package main.DAO.Impl;

import main.DAO.MentorDao;
import main.Util.DruidUtil;
import main.pojo.Admin;
import main.pojo.Mentor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MentorDaoImpl implements MentorDao {
    @Override
    public void addMentor(Mentor mentor) {

    }

    @Override
    public void updateMentor(Mentor mentor) {

    }

    @Override
    public void deleteMentor(String me_id) {

    }

    @Override
    public Mentor getMentor(String me_id) {
        return null;
    }

    @Override
    public List<Mentor> findMentors(Mentor mentor) {
        String STUDENT_INSERT_SQL = "select * from Mentor where me_name=? and me_pwd=? ";
        Connection con = null;
        List<Mentor> a=new ArrayList<>();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(STUDENT_INSERT_SQL);
            psmt.setString(1, mentor.getMe_name());
            psmt.setString(2, mentor.getMe_pwd());
            ResultSet rs=psmt.executeQuery();
            while(rs.next()){
                Mentor t=new Mentor();
                t.setMe_id(rs.getString(1));
                a.add(t);
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
        return a;
    }
}
