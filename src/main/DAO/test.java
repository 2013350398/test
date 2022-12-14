package main.DAO;

import main.pojo.Subject;

import java.util.List;
public class test {
    public static void main(String[] args) {
        Subject gr=new Subject();
        gr.setSu_id("003");
        gr.setSu_name("计算机");
        DAOFactory.getInstance().getSubjectDAO().addSubject(gr);
        System.out.println("add:"+DAOFactory.getInstance().getSubjectDAO().getSubject("001").toString());

        Subject grup=new Subject();
        grup.setSu_id("001");
        grup.setSu_name("英语");
        DAOFactory.getInstance().getSubjectDAO().updateSubject(grup);
        System.out.println("update:"+DAOFactory.getInstance().getSubjectDAO().getSubject("002").toString());

        System.out.println("get:"+DAOFactory.getInstance().getSubjectDAO().getSubject("002").toString());
        Subject grfinds=new Subject();
        grfinds.setSu_id("0");
        List<Subject> list=DAOFactory.getInstance().getSubjectDAO().findSubjects(grfinds);
        for(Subject a:list){ System.out.println(a); }

        DAOFactory.getInstance().getSubjectDAO().deleteSubject("002");
        System.out.println("delete:"+DAOFactory.getInstance().getSubjectDAO().getSubject("002").toString());
    }
}
