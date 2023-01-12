package main.pojo;

public class Teacher {
    private String te_id;
    private String te_pwd;
    private String te_name;
    private String te_tel;
    private String te_email;

    public String getTe_id() {
        return te_id;
    }

    public void setTe_id(String te_id) {
        this.te_id = te_id;
    }

    public String getTe_pwd() {
        return te_pwd;
    }

    public void setTe_pwd(String te_pwd) {
        this.te_pwd = te_pwd;
    }

    public String getTe_name() {
        return te_name;
    }

    public void setTe_name(String te_name) {
        this.te_name = te_name;
    }

    public String getTe_tel() {
        return te_tel;
    }

    public void setTe_tel(String te_tel) {
        this.te_tel = te_tel;
    }

    public String getTe_email() {
        return te_email;
    }

    public void setTe_email(String te_email) {
        this.te_email = te_email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "te_id='" + te_id + '\'' +
                ", te_pwd='" + te_pwd + '\'' +
                ", te_name='" + te_name + '\'' +
                ", te_tel='" + te_tel + '\'' +
                ", te_email='" + te_email + '\'' +
                '}';
    }
}
