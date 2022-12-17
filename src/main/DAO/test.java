package main.DAO;

import main.pojo.Graduate;
import main.pojo.Project;
import main.graduate.graduateController;
import main.project_identify.projectController;
import main.project_identify.project_identifyController;
import java.util.List;
public class test {
    public static void main(String[] args) {
        graduateController graduateController=new graduateController();
//        //新建毕业审核表
//        graduateController.addGraduate();
//        //查看所有毕业审核表信息
//        graduateController.admingetall();
//        //审核毕业
//        graduateController.trail("001");

        project_identifyController project_identifyController=new project_identifyController();
//        //更新学生毕业审核表项目认定次数
//        project_identifyController.updatepi_num();
//        //学生新建认定的参与项目信息
//        project_identifyController.addProject_identify();
//          //项目管理员或导师修改签字状态
//        project_identifyController.sign("通过",0,"001","002");
//        project_identifyController.sign("通过",1,"001002","002");
//        //项目管理员查询自己管理的各个项目信息的相关学生认证表信息
//        project_identifyController.plget("002");
//        //导师查询自己下属的各个项目信息的相关学生认证表信息
//        project_identifyController.meget("002");
//        //学生查询自己申请的认证项目信息
//        project_identifyController.stget("001");
//        //研究生培养管理员查询所有项目认证表
//        project_identifyController.adget();

        projectController projectController=new projectController();
        //新建
//        projectController.addProject("001");//002 基于图像分析进行水质研究 国家级项目 002
//        //查找
//        projectController.adget();
//        projectController.stget();
//        projectController.meget("002");
//        projectController.plget("002");

//        Project gr=new Project();
//        gr.setPr_id("002");
//        gr.setPr_name("计算机");
//        gr.setPr_type("国家级");
//        gr.setPl_id("001");
//        gr.setMe_id("001");
//        DAOFactory.getInstance().getProjectDAO().addProject(gr);
//        System.out.println("add:"+DAOFactory.getInstance().getProjectDAO().getProject("001").toString());
//
//        Project grup=new Project();
//        grup.setPr_id("001");
//        grup.setPr_name("英语");
//        grup.setPr_type("校级");
//        grup.setPl_id("002");
//        grup.setMe_id("002");
//        DAOFactory.getInstance().getProjectDAO().updateProject(grup);
//        System.out.println("update:"+DAOFactory.getInstance().getProjectDAO().getProject("001").toString());
//
//        System.out.println("get:"+DAOFactory.getInstance().getProjectDAO().getProject("001").toString());
//        Project grfinds=new Project();
//        grfinds.setPr_id("0");
//        List<Project> list=DAOFactory.getInstance().getProjectDAO().findProjects(grfinds);
//        for(Project a:list){ System.out.println(a); }
//
//        DAOFactory.getInstance().getProjectDAO().deleteProject("001");
//        System.out.println("delete:"+DAOFactory.getInstance().getProjectDAO().getProject("002").toString());


//        Project gr=new Project();
//        gr.setPr_id("002");
//        gr.setPr_name("计算机");
//        gr.setPr_type("国家级");
//        gr.setPl_id("001");
//        gr.setMe_id("001");
//        DAOFactory.getInstance().getProjectDAO().addProject(gr);
//        System.out.println("add:"+DAOFactory.getInstance().getProjectDAO().getProject("001").toString());
//
//        Project grup=new Project();
//        grup.setPr_id("001");
//        grup.setPr_name("英语");
//        grup.setPr_type("校级");
//        grup.setPl_id("002");
//        grup.setMe_id("002");
//        DAOFactory.getInstance().getProjectDAO().updateProject(grup);
//        System.out.println("update:"+DAOFactory.getInstance().getProjectDAO().getProject("001").toString());
//
//        System.out.println("get:"+DAOFactory.getInstance().getProjectDAO().getProject("001").toString());
//        Project grfinds=new Project();
//        grfinds.setPr_id("0");
//        List<Project> list=DAOFactory.getInstance().getProjectDAO().findProjects(grfinds);
//        for(Project a:list){ System.out.println(a); }
//
//        DAOFactory.getInstance().getProjectDAO().deleteProject("001");
//        System.out.println("delete:"+DAOFactory.getInstance().getProjectDAO().getProject("002").toString());
    }
}
