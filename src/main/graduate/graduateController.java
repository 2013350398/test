package main.graduate;

import main.DAO.DAOFactory;
import main.pojo.Graduate;

import java.util.List;
import java.util.Scanner;

public class graduateController {
    //增加学生毕业审核表
    public void addGraduate(){
        Graduate graduate=new Graduate();
        System.out.println("请输入：学生编号");
        Scanner sc=new Scanner(System.in);
        graduate.setSt_id(sc.next());
        graduate.setGr_id(graduate.getSt_id());//默认毕业审核表编号与学生编号一致
        graduate.setPi_num(0);
        graduate.setAs_num(0);
        graduate.setAca_num(0);
        graduate.setAch_num(0);
        graduate.setGr_state("不满足");
        List<Graduate> graduateList=DAOFactory.getInstance().getGraduateDAO().getAllGraduates();
        for(Graduate temp:graduateList){
            if(temp.getGr_id().equals(graduate.getGr_id())){
                System.out.println("该学生的毕业审核表已存在，禁止重复添加！");
                return;
            }
        }
        DAOFactory.getInstance().getGraduateDAO().addGraduate(graduate);
        System.out.println("新建学生毕业审核表成功！");
    }
    //查看毕业审核表信息
    public void admingetall(){
        List<Graduate> graduateList=DAOFactory.getInstance().getGraduateDAO().getAllGraduates();
        System.out.println("毕业审核表共有"+graduateList.size()+"条，具体如下：");
        for (Graduate temp:graduateList){
            System.out.println(temp.toString());
        }
    }
    //审核毕业情况
    public void trail(String st_id){
        Graduate graduate=DAOFactory.getInstance().getGraduateDAO().getGraduateBySt_id(st_id);
        if((graduate.getAca_num()>=2)&&(graduate.getAch_num()>=1)&&(graduate.getPi_num()>=1)&&(graduate.getAs_num()>=1)){//满足毕业条件
            if(graduate.getGr_state().equals("不满足")){
                graduate.setGr_state("满足");
                DAOFactory.getInstance().getGraduateDAO().updateGraduate(graduate);
                System.out.println("通过该学生毕业审核！");
            }
            else{
                System.out.println("已通过该学生毕业审核！");
            }
        }
        else{
            System.out.println("该学生暂未达到毕业资质，具体信息如下");
            System.out.println(graduate.toString());
        }
    }
}
