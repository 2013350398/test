package main.pojo;

import java.util.Date;

public class Evaluate {
    private int ev_id;
    private String st_id;
    private String co_id;
    private String self_eva;
    private String sub_time;
    private String te_eva;
    private String te_idea;
    private String te_time;

    public int getEv_id() {
        return ev_id;
    }

    public void setEv_id(int ev_id) {
        this.ev_id = ev_id;
    }

    public String getSt_id() {
        return st_id;
    }

    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }

    public String getCo_id() {
        return co_id;
    }

    public void setCo_id(String co_id) {
        this.co_id = co_id;
    }

    public String getSelf_eva() {
        return self_eva;
    }

    public void setSelf_eva(String self_eva) {
        this.self_eva = self_eva;
    }

    public String getSub_time() {
        return sub_time;
    }

    public void setSub_time(String sub_time) {
        this.sub_time = sub_time;
    }

    public String getTe_eva() {
        return te_eva;
    }

    public void setTe_eva(String te_eva) {
        this.te_eva = te_eva;
    }

    public String getTe_idea() {
        return te_idea;
    }

    public void setTe_idea(String te_idea) {
        this.te_idea = te_idea;
    }

    public String getTe_time() {
        return te_time;
    }

    public void setTe_time(String te_time) {
        this.te_time = te_time;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "ev_id='" + ev_id + '\'' +
                ", st_id='" + st_id + '\'' +
                ", co_id='" + co_id + '\'' +
                ", self_eva='" + self_eva + '\'' +
                ", sub_time=" + sub_time +
                ", te_eva='" + te_eva + '\'' +
                ", te_idea='" + te_idea + '\'' +
                ", te_time=" + te_time +
                '}';
    }
}
