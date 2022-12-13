package main.pojo;

public class Mentor {
    String me_id;
    String me_name;
    String me_pwd;
    String me_sex;
    String me_tel;
    String me_email;

    @Override
    public String toString() {
        return "Mentor{" +
                "me_id='" + me_id + '\'' +
                ", me_name='" + me_name + '\'' +
                ", me_pwd='" + me_pwd + '\'' +
                ", me_sex='" + me_sex + '\'' +
                ", me_tel='" + me_tel + '\'' +
                ", me_email='" + me_email + '\'' +
                '}';
    }

    public String getMe_id() {
        return me_id;
    }

    public void setMe_id(String me_id) {
        this.me_id = me_id;
    }

    public String getMe_name() {
        return me_name;
    }

    public void setMe_name(String me_name) {
        this.me_name = me_name;
    }

    public String getMe_pwd() {
        return me_pwd;
    }

    public void setMe_pwd(String me_pwd) {
        this.me_pwd = me_pwd;
    }

    public String getMe_sex() {
        return me_sex;
    }

    public void setMe_sex(String me_sex) {
        this.me_sex = me_sex;
    }

    public String getMe_tel() {
        return me_tel;
    }

    public void setMe_tel(String me_tel) {
        this.me_tel = me_tel;
    }

    public String getMe_email() {
        return me_email;
    }

    public void setMe_email(String me_email) {
        this.me_email = me_email;
    }
}
