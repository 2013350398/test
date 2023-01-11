
package dao;

import dao.DAOImpl.*;

public class DAOFactory {
    // 单例: 私有静态成员, 加载类时初始化实例, 私有构造函数
    private static  DAOFactory daoFactory;
    static {
        daoFactory = new DAOFactory();
    }
    private  DAOFactory() {}

    public static DAOFactory getInstance() {
        return daoFactory;
    }

    public StudentDAO getStudentDAO() {
        return new StudentDAOImpl();
    }
    public MentorDAO getMentorDAO() {return new MentorDAOImpl();}
    public AdminDAO getAdminDAO() {return new AdminDAOImpl();}

    public Me_StDAO getMe_StDAO() {
        return new Me_StDAOImpl();
    }

    public VerifyDAO getVerifyDAO() {
        return new VerifyDAOImpl();
    }
    public ThesisDAO getThesisDAO() {
        return new ThesisDAOImpl();
    }
    public AwardDAO getAwardDAO() {
        return new AwardDAOImpl();
    }
    public PatentDAO getPatentDAO() {
        return new PatentDAOImpl();
    }
    public ReportDAO getReportDAO() {
        return new ReportDAOImpl();
    }
    public StandardDAO getStandardDAO() {
        return new StandardDAOImpl();
    }
    public TextbookDAO getTextbookDAO() {
        return new TextbookDAOImpl();
    }
    public DevelopmentDAO getDevelopmentDAO() {
        return new DevelopmentDAOImpl();
    }
    public OtherDAO getOtherDAO() {
        return new OtherDAOImpl();
    }
}