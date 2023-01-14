
package main.achiev_submit;

import main.DAO.DAOFactory;
import main.graduate.graduateController;
import main.pojo.Me_St;
import main.pojo.Student;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdminAddStudent {
    private graduateController con=new graduateController();

    // 建立已有的导师和学生的联系
    public void addMe_St() {
        // 单个插入
        System.out.println("输入导师ID: ");
        Scanner sc = new Scanner(System.in);
        String me_id = sc.next();
        System.out.println("输入学生ID: ");
        sc = new Scanner(System.in);
        String st_id = sc.next();
        Me_St me_st = new Me_St(me_id, st_id);
        DAOFactory.getInstance().getMe_StDAO().insert(me_st);
    }
    //excel导入新生-导师&生成新生账号
    public void addMe_StByExcel() {
        System.out.println("输入Excel文件路径:");//C:\Users\20133\Desktop\2.xls
        Scanner sc = new Scanner(System.in);
        String filePath = sc.next();
        try {
            Workbook workbook = Workbook.getWorkbook(new File(filePath));
            Sheet sheet = workbook.getSheet(0);
            for(int i = 1; i < sheet.getRows(); i ++) {
                String me_id = sheet.getCell(0, i).getContents();
                String st_id = sheet.getCell(1, i).getContents();
                String su_id = sheet.getCell(2, i).getContents();//su_id
                if(me_id.equals("")){ break; }
                System.out.println(me_id+" "+st_id+" "+su_id);
                DAOFactory.getInstance().getMe_StDAO().insert(new Me_St(me_id, st_id));
                System.out.println("新建导师学生联系成功！");
                DAOFactory.getInstance().getStudentDAO().insertStUser(st_id, st_id,su_id);
                System.out.println("新建学生成功！");
                //新建毕业审核表
                con.addGraduate(st_id);//新建毕业信息
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (BiffException e) {
            throw new RuntimeException(e);
        }
    }

    // 生成导师名下的学生账号---不用了
    public void addStUser() {
        System.out.println("输入Excel文件路径:");
        Scanner sc = new Scanner(System.in);
        String filePath = sc.next();
        try {
            Workbook workbook = Workbook.getWorkbook(new File(filePath));
            Sheet sheet = workbook.getSheet(0);
            for(int i = 1; i < sheet.getRows(); i ++) {
                String st_id = sheet.getCell(0, i).getContents();
                String su_id = sheet.getCell(1, i).getContents();//su_id
                DAOFactory.getInstance().getStudentDAO().insertStUser(st_id, st_id,su_id);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (BiffException e) {
            throw new RuntimeException(e);
        }
    }
}
//package main.achiev_submit;
//
//import main.DAO.DAOFactory;
//import main.pojo.Me_St;
//import main.pojo.Student;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.Scanner;
//
//public class AdminAddStudent {
//    // 建立导师和学生的联系
//    public void addMe_St() {
//        // 单个插入
//        System.out.println("输入导师ID: ");
//        Scanner sc = new Scanner(System.in);
//        String me_id = sc.next();
//        System.out.println("输入学生ID: ");
//        sc = new Scanner(System.in);
//        String st_id = sc.next();
//
//        Me_St me_st = new Me_St(me_id, st_id);
//        DAOFactory.getInstance().getMe_StDAO().insert(me_st);
//    }
//
//    public void addMe_StByExcel() {
//        Scanner sc = new Scanner(System.in);
//        String filePath = sc.next();
//        try {
//            Workbook workbook = Workbook.getWorkbook(new File(filePath));
//            Sheet sheet = workbook.getSheet(0);
//            for(int i = 1; i < sheet.getRows(); i ++) {
//                String me_id = sheet.getCell(0, i).getContents();
//                String st_id = sheet.getCell(1, i).getContents();
//                DAOFactory.getInstance().getMe_StDAO().insert(new Me_St(me_id, st_id));
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (BiffException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    // 生成导师名下的学生账号
//    public void addStUser(List<Student> students) {
//        // 传入参数和生成形式？？？
//        // 需要调学生管理（？）那边的接口，这边表没建全
//    }
//}