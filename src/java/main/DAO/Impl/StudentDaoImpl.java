/*
package main.DAO.Impl;

import main.DAO.StudentDao;
import main.Util.DruidUtil;
import main.pojo.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

//学生
public class StudentDaoImpl implements StudentDao {
    @Override
    public void addStudent(Student student) {
        String STUDENT_SELECT_SQL = "insert into Student values (?,?,?,?,?,?)";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(STUDENT_SELECT_SQL);
            psmt.setString(1, student.getSno());
            psmt.setString(2, student.getName());
            psmt.setString(3, student.getGender());
            psmt.setString(4, student.getMajor());
            psmt.setString(5, student.getBirth());
            psmt.setString(6, student.getTele());
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
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(String st_id) {

    }

    @Override
    public Student getStudent(String st_id) {
        return null;
    }

    @Override
    public List<Student> findStudents(Student student) {
        return null;
    }



    @Override
    public void selectAll() {
        String STUDENT_SELECT_SQL = "select * from Student";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            */
/*PreparedStatement psmt = con.prepareStatement(STUDENT_INSERT_SQL);
            psmt.setString(1, admin.getAd_id());
            psmt.setString(2, admin.getAd_name());
            psmt.setString(3, admin.getAd_pwd());
            psmt.executeUpdate();
            psmt.close();*//*

            Statement statement=con.createStatement();
            ResultSet resultSet =statement.executeQuery(STUDENT_SELECT_SQL);
            List<Student> s;
            while(resultSet.next()){
                System.out.println(resultSet.getString("sno")+" "+resultSet.getString("name")+" "+resultSet.getString("gender")+" "+resultSet.getString("major")+" "+resultSet.getString("birth")+" "+resultSet.getString("tele"));
            }
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


}
*/
