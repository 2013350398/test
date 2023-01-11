package main.project_identify;

import main.DAO.DAOFactory;
import main.pojo.Graduate;
import main.pojo.Project;
import main.pojo.Project_indentify;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class project_identifyController {

    public Project project;
    //学生新建认定的参与项目信息
    public void addProject_identify(){//001 002 2020/10/01-2022/09/30 测试
        Project_indentify PI=new Project_indentify();
        System.out.println("请输入：项目编号\t学生编号\t参与项目时间\t承担工作");
        Scanner sc=new Scanner(System.in);
        PI.setPr_id(sc.next());
        PI.setSt_id(sc.next());
        PI.setPi_time(sc.next());
        PI.setPi_work(sc.next());
        PI.setPi_plstate("待审核");
        PI.setPi_mestate("待审核");
        //判断重复申请
        int flag=0;
        List<Project_indentify>project_indentifyList=DAOFactory.getInstance().getProject_indentifyDAO().getAllProjectProject_indentifys();
        for(Project_indentify temp:project_indentifyList){
            if(temp.getSt_id().equals(PI.getSt_id())&&temp.getPr_id().equals(PI.getPr_id())){
                flag=1;
                break;
            }
        }
        if(flag==1){
            System.out.println("不可重复认定！");
        }
        else{
            //设置编号
            StringBuffer suf=new StringBuffer();
            suf.append(PI.getPr_id());
            suf.append(PI.getSt_id());
            PI.setPi_id(suf.toString());
            DAOFactory.getInstance().getProject_indentifyDAO().addProject_indentify(PI);
            System.out.println("项目认证申请成功，请等待审核！");
        }
    }

    //修改
    //项目管理员或导师修改签字状态
    public void sign(String state,int person,String pi_id,String person_id){
        Project_indentify project_indentify=DAOFactory.getInstance().getProject_indentifyDAO().getProject_indentify(pi_id);
        if(project_indentify==null){
            System.out.println("未查询到此项目！");
            return;
        }
        //验证身份
        Project project=DAOFactory.getInstance().getProjectDAO().getProject(project_indentify.getPr_id());
        if((person==0)&&(project.getPl_id().equals(person_id))){//项目负责人
            project_indentify.setPi_plstate(state);
            System.out.println("请输入项目折合资金：");
            Scanner sc=new Scanner(System.in);
            project_indentify.setPi_funding(sc.next());
        }
        else if((person==1)&&(project.getMe_id().equals(person_id))){//导师
            project_indentify.setPi_mestate(state);
        }
        else{
            System.out.println("您无权改变该研究生参与项目认定表信息！");
        }
        DAOFactory.getInstance().getProject_indentifyDAO().updateProject_indentify(project_indentify);
        System.out.println("审核完毕！");
    }
    //研究生培养管理员修改全部通过认证的学生毕业审核表中的项目认定次数（+1）
    public void updatepi_num(){
        List<Project_indentify>project_indentifyList=DAOFactory.getInstance().getProject_indentifyDAO().getAllProjectProject_indentifys();
        for(Project_indentify temp:project_indentifyList){
            if((temp.getPi_mestate().equals("通过"))&&(temp.getPi_plstate().equals("通过"))){//
                Graduate graduate=DAOFactory.getInstance().getGraduateDAO().getGraduateBySt_id(temp.getSt_id());
                int num=graduate.getPi_num();
                graduate.setPi_num(num+1);
                DAOFactory.getInstance().getGraduateDAO().updateGraduate(graduate);
                System.out.println("审核通过，修改学生编号为"+temp.getSt_id()+"的毕业审核表中项目认定次数成功！");
            }
        }
    }

    //查询
    //项目管理员查询自己管理的各个项目信息的相关学生认证表信息
    public void plget(String pl_id){
        List<Project> projectList=DAOFactory.getInstance().getProjectDAO().findProjectsBYPl_id(pl_id);
        List<Project_indentify>project_indentifyList=new ArrayList<>();
        for(Project temp:projectList){//每个项目都查找对应认证表
            List<Project_indentify>pitemp=new ArrayList<>();
            pitemp=DAOFactory.getInstance().getProject_indentifyDAO().findProject_indentifysBYPr_id(temp.getPr_id());
            for (Project_indentify t:pitemp){//加入
                project_indentifyList.add(t);
            }
        }
        System.out.println("您管理的项目相关的项目认证表共有"+project_indentifyList.size()+"条，具体如下：");
        for(Project_indentify temp:project_indentifyList){
            System.out.println(temp.toString());
        }
    }
    //导师查询自己下属的各个项目信息的相关学生认证表信息
    public void meget(String me_id){
        List<Project> projectList=DAOFactory.getInstance().getProjectDAO().findProjectsBYMe_id(me_id);
        List<Project_indentify>project_indentifyList=new ArrayList<>();
        for(Project temp:projectList){//每个项目都查找对应认证表
            List<Project_indentify>pitemp=new ArrayList<>();
            pitemp=DAOFactory.getInstance().getProject_indentifyDAO().findProject_indentifysBYPr_id(temp.getPr_id());
            for (Project_indentify t:pitemp){//加入
                project_indentifyList.add(t);
            }
        }
        System.out.println("您下属的项目相关的项目认证表共有"+project_indentifyList.size()+"条，具体如下：");
        for(Project_indentify temp:project_indentifyList){
            System.out.println(temp.toString());
        }
    }
    //学生查询自己申请的认证项目信息
    public void stget(String st_id){
        List<Project_indentify>project_indentifyList=DAOFactory.getInstance().getProject_indentifyDAO().findProject_indentifysBYSt_id(st_id);
        System.out.println("您申请认证的项目共有"+project_indentifyList.size()+"条，具体如下：");
        for(Project_indentify temp:project_indentifyList){
            System.out.println(temp.toString());
        }
    }
    //研究生培养管理员查询所有项目认证表
    public void adget(){
        List<Project_indentify>project_indentifyList=DAOFactory.getInstance().getProject_indentifyDAO().getAllProjectProject_indentifys();
        System.out.println("项目认证表共有"+project_indentifyList.size()+"条，具体如下：");
        for(Project_indentify temp:project_indentifyList){
            System.out.println(temp.toString());
        }
    }
}
