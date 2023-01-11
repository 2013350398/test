package main.DAO;

import main.DAO.Impl.AcademicDaoImpl;
import main.DAO.Impl.AdminDaoImpl;
//import main.DAO.Impl.StudentDaoImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    static {
        daoFactory = new DAOFactory();
    }
    private DAOFactory(){
    }
    public static DAOFactory getInstance(){
        return daoFactory;
    }
    public AdminDao getAdminDAO(){
        return new AdminDaoImpl();
    }

   /* public StudentDao getStudentDao(){
        return new StudentDaoImpl();
    }*/
    public AcademicDao getAcademicDao(){
        return new AcademicDaoImpl();
    }
//    public ClassDao getClassDAO(){
//        return new ClassDaoImpl();
//    }
//    public HomeworkDao getHomeworkDAO(){ return new HomeworkDaoImpl(); }
}
