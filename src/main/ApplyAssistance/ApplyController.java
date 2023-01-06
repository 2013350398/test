package main.ApplyAssistance;

import main.CustomType.ApaTeacher;
import main.DAO.DAOFactory;
import main.pojo.*;

import java.util.*;

public class ApplyController {
    //登录
    /*
    public void Login(){
        System.out.println("请选择您的身份:\n1.学生\n2.授课教师");
        Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);
        int cnt=sc.nextInt();
        switch(cnt){
            case 1:
                System.out.println("请输入您的学号:");
                String uid=sc1.nextLine();
                System.out.println("请输入您的密码:");
                String pwd=sc1.nextLine();
                Student student=DAOFactory.getInstance().getStudentDAO().getStudent(uid);
                if(student!=null && student.getSt_pwd().equals(pwd)){
                    System.out.println("1.申请助教\n2.填写助教评定表\n请输入您要进行的操作:");
                    int i = sc.nextInt();
                    if(i==1)
                        Apply(uid);
                    else
                        stuEvaluate(uid);
                }
                break;
            case 2:
                System.out.println("请输入您的工号:");
                String tid=sc1.nextLine();
                System.out.println("请输入您的密码:");
                String tpwd=sc1.nextLine();
                Teacher teacher=DAOFactory.getInstance().getTeacherDao().getTeacher(tid);
                if (teacher!=null && teacher.getTe_pwd().equals(tpwd)){
                    System.out.println("1.选择助教\n2.填写助教评定表");
                    System.out.println("请输入您要进行的操作:");
                    int i = sc.nextInt();
                    if(i == 1)
                        Judge(tid);
                    else
                        teaEvaluate(tid);
                }
                break;
        }

    }*/
    //研究生申请助教
    public void Apply(String st_id){
        Scanner sc = new Scanner(System.in);
        List<CourseTeacher> courseList= DAOFactory.getInstance().getCourseDAO().COURSE_LIST();
        Collections.sort(courseList, Comparator.comparing(CourseTeacher::getCo_num).reversed());
        System.out.println("========================================================");
        System.out.println("                           课程信息                       ");
        System.out.println("=========================================================");
        System.out.println("课程号\t课程名\t授课教师号\t教师姓名\t课程性质\t选课人数\t授课对象\t课程学时");
        for(CourseTeacher course:courseList){
            System.out.println(course.getCo_id()+'\t'+course.getCo_name()+'\t'+course.getCt_id()+'\t'+course.getTe_name()+'\t'+
                    course.getCo_nature()+'\t'+course.getCo_num()+'\t'+course.getCo_object()+'\t'+course.getCo_hours());
        }
        while (true){
            System.out.println("请输入您要申请的课程号:");
            String cid = sc.nextLine();
            Application application = new Application();
            application.setCo_id(cid);
            application.setSt_id(st_id);
            DAOFactory.getInstance().getApplicationDao().addApplication(application);
            System.out.println("申请成功!\n是否继续申请(是/否):");
            String str = sc.nextLine();
            if(str.equals("是"))
                continue;
            else break;
        }
    }

    public void Judge(String tid){
        Scanner sc = new Scanner(System.in);
        List<ApaTeacher> apaTeacherList=DAOFactory.getInstance().getApplicationDao().APA_TEACHER_LIST(tid);
        System.out.println("========================================");
        System.out.println("                  助教申请信息");
        System.out.println("========================================");
        System.out.println("申请编号\t课程号\t课程名\t学生学号\t学生姓名");
        for(ApaTeacher apaTeacher:apaTeacherList)
            System.out.println(apaTeacher.getSa_id()+'\t'+apaTeacher.getCo_id()+'\t'+apaTeacher.getCo_name()
            +'\t'+apaTeacher.getSt_id()+'\t'+apaTeacher.getSt_name());
        while(true){
            System.out.println("请输入您要选择的助教的申请表单号:");
            int sa_id = sc.nextInt();
            for(ApaTeacher apaTeacher:apaTeacherList){
                if(apaTeacher.getSa_id().equals(sa_id)){
                    //更新课程表的助教编号字段
                    Course course=DAOFactory.getInstance().getCourseDAO().getCourse(apaTeacher.getCo_id());
                    course.setAssistance_id(apaTeacher.getSt_id());
                    DAOFactory.getInstance().getCourseDAO().updateCourse(course);
                    //更新学生表的是否为助教字段
                    Student student=DAOFactory.getInstance().getStudentDAO().getStudent(apaTeacher.getSt_id());
                    student.setIs_assistance(1);
                    DAOFactory.getInstance().getStudentDAO().updateStudent(student);
                    //创建助教评定表
                    Evaluate evaluate = new Evaluate();
                    evaluate.setCo_id(apaTeacher.getCo_id());
                    evaluate.setSt_id(apaTeacher.getSt_id());
                    DAOFactory.getInstance().getEvaluateDao().addEvaluate(evaluate);
                    System.out.println("选择成功!");
                    break;
                }
            }
            System.out.println("是否继续该操作(是/否):");
            String str = sc.nextLine();
            if(str.equals("是"))
                continue;
            else break;
        }
    }

    //助教填写助教评定表
    public void stuEvaluate(String st_id){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
       List<Evaluate> evaluateList=DAOFactory.getInstance().getEvaluateDao().EVALUATE_LIST(st_id);
        if(evaluateList.size()==0){
            System.out.println("您未担任助教，不可填写助教评定表!");
        }else {
            System.out.println("评定表单号\t课程号\t学号");
            for (Evaluate evaluate:evaluateList){
                System.out.println("评定表单号："+evaluate.getEv_id());
                System.out.println("课程号:"+evaluate.getCo_id());
                System.out.println("学号："+evaluate.getSt_id());
                System.out.println("自我评价："+evaluate.getSelf_eva());
                System.out.println("提交日期："+evaluate.getSub_time());
                System.out.println("教师评语："+evaluate.getTe_eva());
                System.out.println("教师意见："+evaluate.getTe_idea());
                System.out.println("教师评价日期"+evaluate.getTe_time());
                System.out.println("==================================");
            }
            while (true){
                System.out.println("请输入您要填写的评定表单号:");
                int id = sc.nextInt();
                for(Evaluate evaluate:evaluateList){
                    if(id == evaluate.getEv_id()){
                        System.out.println("请输入您的自我评价(100字以内):");
                        String selt_eva=sc1.nextLine();
                        evaluate.setSelf_eva(selt_eva);
                        Date date = new Date();
                        evaluate.setSub_time(date);
                        DAOFactory.getInstance().getEvaluateDao().updateEvaluate(evaluate);
                        System.out.println("填写成功!");
                        break;
                    }
                }
                System.out.println("是否继续该操作(是/否):");
                String str = sc.nextLine();
                if(str.equals("是"))
                    continue;
                else break;
            }
        }
    }

    public void teaEvaluate(String te_id){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        List<Evaluate> evaluateList=DAOFactory.getInstance().getEvaluateDao().TEVALUATE_LIST(te_id);
        if(evaluateList.size()==0){
            System.out.println("您未担任助教，不可填写助教评定表!");
        }else {
            for (Evaluate evaluate:evaluateList){
                System.out.println("表单号:"+evaluate.getEv_id());
                System.out.println("助教编号:"+evaluate.getSt_id());
                System.out.println("课程编号:"+evaluate.getCo_id());
                System.out.println("助教自我评价:"+evaluate.getSelf_eva());
                System.out.println("表单提交时间:"+evaluate.getSub_time());
                System.out.println("教师评语："+evaluate.getTe_eva());
                System.out.println("教师意见："+evaluate.getTe_idea());
                System.out.println("教师评价日期"+evaluate.getTe_time());
                System.out.println("====================================");
            }
            while (true){
                System.out.println("请输入您要填写的评定表单号:");
                int id = sc.nextInt();
                for(Evaluate evaluate:evaluateList){
                    if(id == evaluate.getEv_id()){
                        System.out.println("请输入您对助教的评价(100字以内):");
                        String te_eva=sc1.nextLine();
                        evaluate.setTe_eva(te_eva);
                        System.out.println("请输入您的建议(合格/不合格):");
                        String idea = sc1.nextLine();
                        evaluate.setTe_idea(idea);
                        Date date = new Date();
                        evaluate.setTe_time(date);
                        DAOFactory.getInstance().getEvaluateDao().updateEvaluate(evaluate);
                        System.out.println("填写成功!");
                        break;
                    }
                }
                System.out.println("是否继续该操作(是/否):");
                String str = sc.nextLine();
                if(str.equals("是"))
                    continue;
                else break;
            }
        }

    }

//    public static void main(String []args){
//        ApplyController applyController=new ApplyController();
//        applyController.Login();
//    }
}
