package main.DAO;

import main.DAO.Impl.AdminDaoImpl;

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
//    public ClassDao getClassDAO(){
//        return new ClassDaoImpl();
//    }
//    public HomeworkDao getHomeworkDAO(){ return new HomeworkDaoImpl(); }
}
