
package dao.DAOImpl;

import dao.DevelopmentDAO;
import entity.Development;
import entity.Patent;
import util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevelopmentDAOImpl implements DevelopmentDAO {

    private static final String selectByNoSQL = "SELECT * FROM development WHERE achiev_no LIKE ?;";
    private static final String insertSQL = "INSERT INTO development VALUES(?,?,?,?,?,?);";

    @Override
    public List<Development> selectByNo(String achiev_no) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Development> developments = new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectByNoSQL);
            pst.setString(1, achiev_no);
            rs = pst.executeQuery();

            while(rs.next()) {
                Development development = new Development();
                development.setAchiev_no(rs.getString("achiev_no"));
                development.setDe_name(rs.getString("de_name"));
                development.setDe_unit(rs.getString("de_unit"));
                development.setDe_time(rs.getString("de_time"));
                development.setDe_contri(rs.getInt("de_contri"));
                development.setDe_evid(rs.getString("de_evid"));
                developments.add(development);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return developments;
    }

    @Override
    public Integer insert(Development development) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Integer ans = 0;

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(insertSQL);
            pst.setString(1, development.getAchiev_no());
            pst.setString(2, development.getDe_name());
            pst.setString(3, development.getDe_unit());
            pst.setString(4, development.getDe_time());
            pst.setInt(5, development.getDe_contri());
            pst.setString(6, development.getDe_evid());
            ans = pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return ans;
    }
}