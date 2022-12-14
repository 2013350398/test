package main.pojo;

public class Graduate {
    String gr_id;
    String st_id;
    int as_num;
    int aca_num;
    int ach_num;
    int pi_num;
    String gr_state;

    @Override
    public String toString() {
        return "Graduate{" +
                "gr_id='" + gr_id + '\'' +
                ", st_id='" + st_id + '\'' +
                ", as_num=" + as_num +
                ", aca_num=" + aca_num +
                ", ach_num=" + ach_num +
                ", pi_num=" + pi_num +
                ", gr_state='" + gr_state + '\'' +
                '}';
    }

    public String getGr_id() {
        return gr_id;
    }

    public void setGr_id(String gr_id) {
        this.gr_id = gr_id;
    }

    public String getSt_id() {
        return st_id;
    }

    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }

    public int getAs_num() {
        return as_num;
    }

    public void setAs_num(int as_num) {
        this.as_num = as_num;
    }

    public int getAca_num() {
        return aca_num;
    }

    public void setAca_num(int aca_num) {
        this.aca_num = aca_num;
    }

    public int getAch_num() {
        return ach_num;
    }

    public void setAch_num(int ach_num) {
        this.ach_num = ach_num;
    }

    public int getPi_num() {
        return pi_num;
    }

    public void setPi_num(int pi_num) {
        this.pi_num = pi_num;
    }

    public String getGr_state() {
        return gr_state;
    }

    public void setGr_state(String gr_state) {
        this.gr_state = gr_state;
    }
}
