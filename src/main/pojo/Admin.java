package main.pojo;
//研究生培养管理员
public class Admin {
    String ad_id;
    String ad_name;
    String ad_pwd;
    String ad_sex;
    String ad_tel;
    String ad_email;

    @Override
    public String toString() {
        return "Admin{" +
                "ad_id='" + ad_id + '\'' +
                ", ad_name='" + ad_name + '\'' +
                ", ad_pwd='" + ad_pwd + '\'' +
                ", ad_sex='" + ad_sex + '\'' +
                ", ad_tel='" + ad_tel + '\'' +
                ", ad_email='" + ad_email + '\'' +
                '}';
    }

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public String getAd_name() {
        return ad_name;
    }

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }

    public String getAd_pwd() {
        return ad_pwd;
    }

    public void setAd_pwd(String ad_pwd) {
        this.ad_pwd = ad_pwd;
    }

    public String getAd_sex() {
        return ad_sex;
    }

    public void setAd_sex(String ad_sex) {
        this.ad_sex = ad_sex;
    }

    public String getAd_tel() {
        return ad_tel;
    }

    public void setAd_tel(String ad_tel) {
        this.ad_tel = ad_tel;
    }

    public String getAd_email() {
        return ad_email;
    }

    public void setAd_email(String ad_email) {
        this.ad_email = ad_email;
    }
}
