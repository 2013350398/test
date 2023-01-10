
package dao.DAOImpl;

import dao.StudentDAO;
import entity.Student;
import util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private static final String selectAllSQL = "SELECT * FROM student;";
    private static final String selectByNoSQL = "SELECT * FROM student WHERE st_id = ?;";
    private static final String selectByNameSQL = "SELECT * FROM student WHERE st_name = ?;";

    @Override
    public List<Student> selectAll() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectAllSQL);
            rs = pst.executeQuery();

            while(rs.next()) {
                Student student = new Student(rs.getString("st_id"), rs.getString("st_name"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return students;
    }

    @Override
    public Student selectBySNo(String st_no) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Student student = null;

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectByNoSQL);
            pst.setString(1, st_no);
            rs = pst.executeQuery();

            while(rs.next()) {
                student = new Student(rs.getString("st_id"), rs.getString("st_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return student;
    }

    @Override
    public List<Student> selectByName(String st_name) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectByNameSQL);
            pst.setString(1, st_name);
            rs = pst.executeQuery();

            while(rs.next()) {
                Student student = new Student(rs.getString("st_id"), rs.getString("st_name"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return students;
    }
}