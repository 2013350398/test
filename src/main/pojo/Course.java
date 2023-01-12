package main.pojo;

import java.util.Date;

public class Course {
    private String co_id;
    private String ct_id;
    private String co_name;
    private String co_nature;
    private Date co_time;
    private String co_object;
    private int co_hours;
    private int co_num;
    private int co_credit;
    private String assistance_id;

    public String getCo_id() {
        return co_id;
    }

    public void setCo_id(String co_id) {
        this.co_id = co_id;
    }

    public String getCt_id() {
        return ct_id;
    }

    public void setCt_id(String ct_id) {
        this.ct_id = ct_id;
    }

    public String getCo_name() {
        return co_name;
    }

    public void setCo_name(String co_name) {
        this.co_name = co_name;
    }

    public String getCo_nature() {
        return co_nature;
    }

    public void setCo_nature(String co_nature) {
        this.co_nature = co_nature;
    }

    public Date getCo_time() {
        return co_time;
    }

    public void setCo_time(Date co_time) {
        this.co_time = co_time;
    }

    public String getCo_object() {
        return co_object;
    }

    public void setCo_object(String co_object) {
        this.co_object = co_object;
    }

    public int getCo_hours() {
        return co_hours;
    }

    public void setCo_hours(int co_hours) {
        this.co_hours = co_hours;
    }

    public int getCo_num() {
        return co_num;
    }

    public void setCo_num(int co_num) {
        this.co_num = co_num;
    }

    public int getCo_credit() {
        return co_credit;
    }

    public void setCo_credit(int co_credit) {
        this.co_credit = co_credit;
    }

    public String getAssistance_id() {
        return assistance_id;
    }

    public void setAssistance_id(String assistance_id) {
        this.assistance_id = assistance_id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "co_id='" + co_id +
                ", ct_id='" + ct_id +
                ", co_name='" + co_name +
                ", co_nature='" + co_nature +
                ", co_time=" + co_time +
                ", co_object='" + co_object +
                ", co_hours=" + co_hours +
                ", co_num=" + co_num +
                ", co_credit=" + co_credit +
                ",assistance_id="+assistance_id+
                '}';
    }
}
