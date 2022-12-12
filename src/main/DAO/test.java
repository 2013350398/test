package main.DAO;

import main.pojo.Admin;

public class test {
    public static void main(String[] args) {
        Admin admin=new Admin();
        admin.setAd_id("001");
        admin.setAd_name("张三");
        admin.setAd_pwd("1");
        DAOFactory.getInstance().getAdminDAO().addAdmin(admin);
//        System.out.println("insert:"+admin.toString()+"\n");
    }
}
