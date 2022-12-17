package main.project_identify;

import main.DAO.DAOFactory;
import main.pojo.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class projectController {
    //项目管理员新建项目
    public void addProject(String pl_id){//003 基于图像分析水质研究 国家级项目 001
        Project project=new Project();
        System.out.println("请输入：项目编号\t项目名称\t项目类型\t导师编号");
        Scanner sc=new Scanner(System.in);
        project.setPr_id(sc.next());
        project.setPr_name(sc.next());
        project.setPr_type(sc.next());
        project.setMe_id(sc.next());
        project.setPl_id(pl_id);
        List<Project> projectList=DAOFactory.getInstance().getProjectDAO().getAllProject();
        for (Project temp:projectList){
            if(temp.getPr_id().equals(project.getPr_id())){
                System.out.println("该项目已存在，请更换编号！");
                return;
            }
        }
        DAOFactory.getInstance().getProjectDAO().addProject(project);
        System.out.println("新建项目成功！");
    }

    //项目管理员查询自己管理的各个项目信息
    public void plget(String pl_id){
        List<Project> projectList= DAOFactory.getInstance().getProjectDAO().findProjectsBYPl_id(pl_id);
        System.out.println("您管理的项目共有"+projectList.size()+"条，具体如下：");
        for(Project temp:projectList){
            System.out.println(temp.toString());
        }
    }

    //导师查询自己下属的各个项目信息
    public void meget(String me_id){
        List<Project> projectList= DAOFactory.getInstance().getProjectDAO().findProjectsBYMe_id(me_id);
        System.out.println("您下属的项目共有"+projectList.size()+"条，具体如下：");
        for(Project temp:projectList){
            System.out.println(temp.toString());
        }
    }

    //学生查询所有项目信息
    public void stget(){
        List<Project> projectList=DAOFactory.getInstance().getProjectDAO().getAllProject();
        System.out.println("项目共有"+projectList.size()+"条，具体如下：");
        for(Project temp:projectList){
            System.out.println(temp.toString());
        }
    }

    //研究生培养管理员查询所有项目
    public void adget(){
        List<Project>projectList=DAOFactory.getInstance().getProjectDAO().getAllProject();
        System.out.println("项目表共有"+projectList.size()+"条，具体如下：");
        for(Project temp:projectList){
            System.out.println(temp.toString());
        }
    }
}
