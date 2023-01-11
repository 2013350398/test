package main.pojo;

public class Project_leader {
    String pl_id;
    String pl_name;
    String pl_pwd;
    String pl_sex;
    String pl_tel;
    String pl_email;

    @Override
    public String toString() {
        return "Project_leader{" +
                "pl_id='" + pl_id + '\'' +
                ", pl_name='" + pl_name + '\'' +
                ", pl_pwd='" + pl_pwd + '\'' +
                ", pl_sex='" + pl_sex + '\'' +
                ", pl_tel='" + pl_tel + '\'' +
                ", pl_email='" + pl_email + '\'' +
                '}';
    }

    public String getPl_id() {
        return pl_id;
    }

    public void setPl_id(String pl_id) {
        this.pl_id = pl_id;
    }

    public String getPl_name() {
        return pl_name;
    }

    public void setPl_name(String pl_name) {
        this.pl_name = pl_name;
    }

    public String getPl_pwd() {
        return pl_pwd;
    }

    public void setPl_pwd(String pl_pwd) {
        this.pl_pwd = pl_pwd;
    }

    public String getPl_sex() {
        return pl_sex;
    }

    public void setPl_sex(String pl_sex) {
        this.pl_sex = pl_sex;
    }

    public String getPl_tel() {
        return pl_tel;
    }

    public void setPl_tel(String pl_tel) {
        this.pl_tel = pl_tel;
    }

    public String getPl_email() {
        return pl_email;
    }

    public void setPl_email(String pl_email) {
        this.pl_email = pl_email;
    }
}
