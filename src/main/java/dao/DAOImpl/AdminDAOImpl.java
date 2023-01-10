/**
 * @BelongsProject: database_keshe
 * @BelongsPackage: dao.DAOImpl
 * @ClassName:AdminDAOImpl
 * @Author: yuzuwxy
 * @CreateTime: 2023-01-09  20:48
 */
package dao.DAOImpl;

import dao.AdminDAO;
import entity.Admin;
import entity.Mentor;
import util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    private static final String selectAllSQL = "SELECT * FROM admin;";
    private static final String selectByNoSQL = "SELECT * FROM admin WHERE ad_id = ?;";
    private static final String selectByNameSQL = "SELECT * FROM admin WHERE ad_name = ?;";

    @Override
    public List<Admin> selectAll() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Admin> admins= new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectAllSQL);
            rs = pst.executeQuery();

            while(rs.next()) {
                Admin admin = new Admin(rs.getString("ad_id"), rs.getString("ad_name"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return admins;
    }

    @Override
    public Admin selectByNo(String ad_no) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Admin admin = null;

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectByNoSQL);
            pst.setString(1, ad_no);
            rs = pst.executeQuery();

            while(rs.next()) {
                admin = new Admin(rs.getString("ad_id"), rs.getString("ad_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return admin;
    }

    @Override
    public List<Admin> selectByName(String ad_name) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Admin> admins= new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectByNameSQL);
            pst.setString(1, ad_name);
            rs = pst.executeQuery();

            while(rs.next()) {
                Admin admin = new Admin(rs.getString("ad_id"), rs.getString("ad_name"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return admins;
    }
}