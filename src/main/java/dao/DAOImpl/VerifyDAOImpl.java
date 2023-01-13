
package dao.DAOImpl;

import dao.VerifyDAO;
import entity.Student;
import entity.Verify;
import searchcriteria.SearchCriteria;
import util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VerifyDAOImpl implements VerifyDAO {

    public static final String selectAllSQL = "SELECT * FROM verify;";
    public static final String selectByNoSQL = "SELECT * FROM verify WHERE achiev_no = ?;";
    public static final String selectBySNoSQL = "SELECT * FROM verify WHERE st_id = ?;";
    public static final String selectByFirstStatusSQL = "SELECT * FROM verify WHERE first_verify = ?;";
    public static final String selectByLastStatusSQL = "SELECT * FROM verify WHERE last_verify = ?;";

    public static final String insertSQL = "INSERT INTO verify(achiev_no, st_id, submit_time) VALUES(?,?,?);";
    public static final String updateMentorSQL = "UPDATE verify SET me_id = ?, first_time = ?, first_verify = ? WHERE achiev_no = ?;";
    public static final String updateAdminSQL = "UPDATE verify SET ad_id = ?, last_time = ?, last_verify = ? WHERE achiev_no = ?;";

    public static final String searchSQL = "SELECT * FROM verify WHERE ";
    public static final String searchByMentorSQL = "SELECT verify.achiev_no, verify.st_id, submit_time, verify.me_id, first_verify, first_time, verify.ad_id, last_verify, last_time" +
            " FROM me_st, verify WHERE me_st.me_id = ? AND verify.st_id = me_st.st_id AND ";

    @Override
    public List<Verify> selectAll() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Verify> verifies = new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectAllSQL);
            rs = pst.executeQuery();

            while(rs.next()) {
                Verify verify = new Verify();
                verify.setAchiev_no(rs.getString("achiev_no"));
                verify.setSt_id(rs.getString("st_id"));
                verify.setSubmit_time(rs.getString("submit_time"));
                verify.setMe_id(rs.getString("me_id"));
                verify.setFirst_time(rs.getString("first_time"));
                verify.setFirst_verify(rs.getInt("first_verify"));
                verify.setAd_id(rs.getString("ad_id"));
                verify.setLast_time(rs.getString("last_time"));
                verify.setLast_verify(rs.getInt("last_verify"));
                verifies.add(verify);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return verifies;
    }

    @Override
    public List<Verify> selectByAchiev(String achiev_no) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Verify> verifies = new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectByNoSQL);
            pst.setString(1, achiev_no);
            rs = pst.executeQuery();

            while(rs.next()) {
                Verify verify = new Verify();
                verify.setAchiev_no(rs.getString("achiev_no"));
                verify.setSt_id(rs.getString("st_id"));
                verify.setSubmit_time(rs.getString("submit_time"));
                verify.setMe_id(rs.getString("me_id"));
                verify.setFirst_time(rs.getString("first_time"));
                verify.setFirst_verify(rs.getInt("first_verify"));
                verify.setAd_id(rs.getString("ad_id"));
                verify.setLast_time(rs.getString("last_time"));
                verify.setLast_verify(rs.getInt("last_verify"));
                verifies.add(verify);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return verifies;
    }

    @Override
    public List<Verify> selectBySNo(String st_id) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Verify> verifies = new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectBySNoSQL);
            pst.setString(1, st_id);
            rs = pst.executeQuery();

            while(rs.next()) {
                Verify verify = new Verify();
                verify.setAchiev_no(rs.getString("achiev_no"));
                verify.setSt_id(rs.getString("st_id"));
                verify.setSubmit_time(rs.getString("submit_time"));
                verify.setMe_id(rs.getString("me_id"));
                verify.setFirst_time(rs.getString("first_time"));
                verify.setFirst_verify(rs.getInt("first_verify"));
                verify.setAd_id(rs.getString("ad_id"));
                verify.setLast_time(rs.getString("last_time"));
                verify.setLast_verify(rs.getInt("last_verify"));
                verifies.add(verify);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return verifies;
    }

    @Override
    public List<Verify> selectByFirstStatus(Integer status) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Verify> verifies = new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectByFirstStatusSQL);
            pst.setInt(1, status);
            rs = pst.executeQuery();

            while(rs.next()) {
                Verify verify = new Verify();
                verify.setAchiev_no(rs.getString("achiev_no"));
                verify.setSt_id(rs.getString("st_id"));
                verify.setSubmit_time(rs.getString("submit_time"));
                verify.setMe_id(rs.getString("me_id"));
                verify.setFirst_time(rs.getString("first_time"));
                verify.setFirst_verify(rs.getInt("first_verify"));
                verify.setAd_id(rs.getString("ad_id"));
                verify.setLast_time(rs.getString("last_time"));
                verify.setLast_verify(rs.getInt("last_verify"));
                verifies.add(verify);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return verifies;
    }

    @Override
    public List<Verify> selectByLastStatus(Integer status) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Verify> verifies = new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectByLastStatusSQL);
            pst.setInt(1, status);
            rs = pst.executeQuery();

            while(rs.next()) {
                Verify verify = new Verify();
                verify.setAchiev_no(rs.getString("achiev_no"));
                verify.setSt_id(rs.getString("st_id"));
                verify.setSubmit_time(rs.getString("submit_time"));
                verify.setMe_id(rs.getString("me_id"));
                verify.setFirst_time(rs.getString("first_time"));
                verify.setFirst_verify(rs.getInt("first_verify"));
                verify.setAd_id(rs.getString("ad_id"));
                verify.setLast_time(rs.getString("last_time"));
                verify.setLast_verify(rs.getInt("last_verify"));
                verifies.add(verify);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return verifies;
    }

    @Override
    public List<Verify> selectByMeId(String me_id) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Verify> verifies = new ArrayList<>();

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(selectByFirstStatusSQL);
            pst.setString(1, me_id);
            rs = pst.executeQuery();

            while(rs.next()) {
                Verify verify = new Verify();
                verify.setAchiev_no(rs.getString("achiev_no"));
                verify.setSt_id(rs.getString("st_id"));
                verify.setSubmit_time(rs.getString("submit_time"));
                verify.setMe_id(rs.getString("me_id"));
                verify.setFirst_time(rs.getString("first_time"));
                verify.setFirst_verify(rs.getInt("first_verify"));
                verify.setAd_id(rs.getString("ad_id"));
                verify.setLast_time(rs.getString("last_time"));
                verify.setLast_verify(rs.getInt("last_verify"));
                verifies.add(verify);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }

        return verifies;
    }

    @Override
    public List<Verify> selectByAdId(String ad_id) {
        return null;
    }

    @Override
    public List<Verify> selectByTime1(String submit_time) {
        return null;
    }

    @Override
    public List<Verify> selectByTime2(String first_time) {
        return null;
    }

    @Override
    public List<Verify> selectByTime3(String last_time) {
        return null;
    }

    @Override
    public List<Verify> selectByCriteria(SearchCriteria searchCriteria) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String criteriaSql = searchCriteria.getCriteriaSQL(searchSQL);
        List<Verify> verifies = new ArrayList<>();

        try{
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(criteriaSql);
            rs = pst.executeQuery();

            while(rs.next()) {
                Verify verify = new Verify();
                verify.setAchiev_no(rs.getString("achiev_no"));
                verify.setSt_id(rs.getString("st_id"));
                verify.setSubmit_time(rs.getString("submit_time"));
                verify.setMe_id(rs.getString("me_id"));
                verify.setFirst_time(rs.getString("first_time"));
                verify.setFirst_verify(rs.getInt("first_verify"));
                verify.setAd_id(rs.getString("ad_id"));
                verify.setLast_time(rs.getString("last_time"));
                verify.setLast_verify(rs.getInt("last_verify"));
                verifies.add(verify);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }
        return verifies;
    }

    @Override
    public List<Verify> salectByMentorCriteria(String me_id, SearchCriteria searchCriteria){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String criteriaSql = searchCriteria.getCriteriaSQL(searchByMentorSQL);
        List<Verify> verifies = new ArrayList<>();

        try{
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(criteriaSql);
            pst.setString(1, me_id);
            rs = pst.executeQuery();

            while(rs.next()) {
                Verify verify = new Verify();
                verify.setAchiev_no(rs.getString("achiev_no"));
                verify.setSt_id(rs.getString("st_id"));
                verify.setSubmit_time(rs.getString("submit_time"));
                verify.setMe_id(rs.getString("me_id"));
                verify.setFirst_time(rs.getString("first_time"));
                verify.setFirst_verify(rs.getInt("first_verify"));
                verify.setAd_id(rs.getString("ad_id"));
                verify.setLast_time(rs.getString("last_time"));
                verify.setLast_verify(rs.getInt("last_verify"));
                verifies.add(verify);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DruidUtil.closeResultSet(rs);
            DruidUtil.closePrepareStatement(pst);
            DruidUtil.closeConnection(conn);
        }
        return verifies;
    }

    @Override
    public Integer insert(Verify verify) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Integer ans = 0;

        try {
            conn = DruidUtil.getConnection();
            pst = conn.prepareStatement(insertSQL);
            pst.setString(1, verify.getAchiev_no());
            pst.setString(2, verify.getSt_id());
            pst.setString(3, verify.getSubmit_time());
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

    @Override
    public Integer updateStatus(Verify verify) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Integer ans = 0;

        try {
            conn = DruidUtil.getConnection();
            if(verify.getMe_id() != null) {
                pst = conn.prepareStatement(updateMentorSQL);
                pst.setString(4, verify.getAchiev_no());
                pst.setString(1, verify.getMe_id());
                pst.setString(2, verify.getFirst_time());
                pst.setInt(3, verify.getFirst_verify());
            }
            if(verify.getAd_id() != null) {
                pst = conn.prepareStatement(updateAdminSQL);
                pst.setString(4, verify.getAchiev_no());
                pst.setString(1, verify.getAd_id());
                pst.setString(2, verify.getLast_time());
                pst.setInt(3, verify.getLast_verify());
            }
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