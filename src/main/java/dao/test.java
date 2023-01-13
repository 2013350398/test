/**
 * @BelongsProject: database_keshe
 * @BelongsPackage: dao
 * @ClassName:test
 * @Author: yuzuwxy
 * @CreateTime: 2023-01-12  00:34
 */
package dao;

import achiev_submit.AdminAddStudent;
import achiev_submit.AdminVerifyController;
import achiev_submit.MentorVerifyController;
import achiev_submit.StudentSubmitController;
import entity.Admin;
import entity.Mentor;
import entity.Student;

import java.util.Scanner;

public class test {
    // 其实是登录之后已经知道身份了
    public static void main(String[] args) {
        AdminAddStudent aad = new AdminAddStudent();
        AdminVerifyController avc = new AdminVerifyController();
        MentorVerifyController mvc = new MentorVerifyController();
        StudentSubmitController ssc = new StudentSubmitController();

        /**
         * 学生的业务逻辑
         */
        /*
        System.out.println(DAOFactory.getInstance().getStudentDAO().selectAll());

        Student student = new Student();    // 假如这个是传进来的学生对象好了
        student.setSt_id("硕士研究生");
        System.out.println("请选择:\n" +
                "1. 提交成果\n" +
                "2. 查看审核情况");
        Scanner sc = new Scanner(System.in);
        Integer choice = sc.nextInt();
        switch(choice) {
            case 1:
                // if(student.getSt_type().equals("博士研究生"))  // 本地数据库没有放这个字段，汇总就可以用了
                if(student.getSt_id().equals("博士研究生"))     // 用一个本地有的字段随便测一测，汇总要用上面那行
                    ssc.PhDsubmitMenu(student.getSt_id());
                else
                    ssc.MDsubmitMenu(student.getSt_id());
                break;
            case 2:
                ssc.selectVerifyMenu(student.getSt_id());
                break;
            default:
                break;
        }
        */

        /**
         * 导师的业务逻辑
         */
        /**
        Mentor mentor = new Mentor();   // 假如这个是传进来的导师
        mentor.setMe_id("0001");
        System.out.println("请选择: \n" +
                "1. 查看成果审核信息\n" +
                "2. 查看提交成果详细信息\n" +
                "3. 修改成果初审状态");
        Scanner sc = new Scanner(System.in);
        Integer choice = sc.nextInt();

        switch (choice) {
            case 1:
                mvc.selectBySelf(mentor.getMe_id());
                break;
            case 2:
                mvc.verifyAchiev(mentor.getMe_id());
                break;
            case 3:
                mvc.mentorFirstVerify(mentor.getMe_id());
                break;
            default:
                break;
        }
         */

        /**
         * 研究生管理员的业务逻辑
         */
        /**
        Admin admin = new Admin();  // 加入这个是登录的研究生管理员
        admin.setAd_id("0000");
        System.out.println("请选择: \n" +
                "1. 查看成果审核信息\n" +
                "2. 查看提交成果详细信息\n" +
                "3. 修改成果终审状态");
        Scanner sc = new Scanner(System.in);
        Integer choice = sc.nextInt();

        switch (choice) {
            case 1:
                avc.select(admin.getAd_id());
                break;
            case 2:
                avc.verifyAchiev(admin.getAd_id());
                break;
            case 3:
                avc.lastVerify(admin.getAd_id());
                break;
            default:
                break;
        }
         */

        /**
         * 新建导师学生联系
         */
//        /**
        System.out.println("请选择:\n" +
                "1. 单个输入\n" +
                "2. Excel文件批量导入\n" +
                "3. 批量生成学生账号(Excel导入)");
        Scanner sc = new Scanner(System.in);
        Integer choice = sc.nextInt();

        switch(choice) {
            case 1:
                aad.addMe_St();
                break;
            case 2:
                aad.addMe_StByExcel();
                break;
            case 3:
                aad.addStUser();
                break;
            default:
                break;
        }
//         */
    }
}