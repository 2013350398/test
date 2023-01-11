package main.DAO.Impl;

import main.DAO.StudentDao;
import main.Util.DruidUtil;
import main.pojo.Mentor;
import main.pojo.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void addStudent(Student student) {

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
        String STUDENT_INSERT_SQL = "select * from Student where st_name=? and st_pwd=? ";
        Connection con = null;
        List<Student> a=new ArrayList<>();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(STUDENT_INSERT_SQL);
            psmt.setString(1, student.getSt_name());
            psmt.setString(2, student.getSt_pwd());
            ResultSet rs=psmt.executeQuery();
            while(rs.next()){
                Student t=new Student();
                t.setSt_id(rs.getString(1));
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

    @Override
    public void selectAll() {

    }
}
