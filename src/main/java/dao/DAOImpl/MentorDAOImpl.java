package dao.DAOImpl;

import dao.MentorDAO;
import entity.Mentor;
import entity.Student;
import util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MentorDAOImpl implements MentorDAO {

    private static final String selectAllSQL = "SELECT * FROM mentor;";
    private static final String selectByNoSQL = "SELECT * FROM mentor WHERE me_id = ?;";
    private static final String selectByNameSQL = "SELECT * FROM mentor WHERE me_name = ?;";

    @Override
    public List<Mentor> selectAll() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Mentor> mentors = new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectAllSQL);
            rs = pst.executeQuery();

            while(rs.next()) {
                Mentor mentor = new Mentor(rs.getString("me_id"), rs.getString("me_name"));
                mentors.add(mentor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return mentors;
    }

    @Override
    public Mentor selectByMNo(String me_no) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Mentor mentor = null;

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectByNoSQL);
            pst.setString(1, me_no);
            rs = pst.executeQuery();

            while(rs.next()) {
                mentor = new Mentor(rs.getString("me_id"), rs.getString("me_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return mentor;
    }

    @Override
    public List<Mentor> selectByName(String me_name) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Mentor> mentors = new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectByNameSQL);
            pst.setString(1, me_name);
            rs = pst.executeQuery();

            while(rs.next()) {
                Mentor mentor = new Mentor(rs.getString("me_id"), rs.getString("me_name"));
                mentors.add(mentor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return mentors;
    }
}