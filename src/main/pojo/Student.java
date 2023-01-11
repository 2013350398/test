package main.pojo;
//学生
public class Student {
    String st_id;
    String st_name;
    String st_pwd;
    String st_sex;
    String st_tel;
    String st_email;
    String st_type;
    String su_id;

    public String getSt_type() {
        return st_type;
    }

    public void setSt_type(String st_type) {
        this.st_type = st_type;
    }

    public String getSu_id() {
        return su_id;
    }

    public void setSu_id(String su_id) {
        this.su_id = su_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "st_id='" + st_id + '\'' +
                ", st_name='" + st_name + '\'' +
                ", st_pwd='" + st_pwd + '\'' +
                ", st_sex='" + st_sex + '\'' +
                ", st_tel='" + st_tel + '\'' +
                ", st_email='" + st_email + '\'' +
                '}';
    }

    public String getSt_id() {
        return st_id;
    }

    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

    public String getSt_pwd() {
        return st_pwd;
    }

    public void setSt_pwd(String st_pwd) {
        this.st_pwd = st_pwd;
    }

    public String getSt_sex() {
        return st_sex;
    }

    public void setSt_sex(String st_sex) {
        this.st_sex = st_sex;
    }

    public String getSt_tel() {
        return st_tel;
    }

    public void setSt_tel(String st_tel) {
        this.st_tel = st_tel;
    }

    public String getSt_email() {
        return st_email;
    }

    public void setSt_email(String st_email) {
        this.st_email = st_email;
    }

}
