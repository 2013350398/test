package main.pojo;

public class Project {
    String pr_id;
    String pr_name;
    String pr_type;
    String pl_id;
    String me_id;

    @Override
    public String toString() {
        return "Project{" +
                "pr_id='" + pr_id + '\'' +
                ", pr_name='" + pr_name + '\'' +
                ", pr_type='" + pr_type + '\'' +
                ", pl_id='" + pl_id + '\'' +
                ", me_id='" + me_id + '\'' +
                '}';
    }

    public String getPr_id() {
        return pr_id;
    }

    public void setPr_id(String pr_id) {
        this.pr_id = pr_id;
    }

    public String getPr_name() {
        return pr_name;
    }

    public void setPr_name(String pr_name) {
        this.pr_name = pr_name;
    }

    public String getPr_type() {
        return pr_type;
    }

    public void setPr_type(String pr_type) {
        this.pr_type = pr_type;
    }

    public String getPl_id() {
        return pl_id;
    }

    public void setPl_id(String pl_id) {
        this.pl_id = pl_id;
    }

    public String getMe_id() {
        return me_id;
    }

    public void setMe_id(String me_id) {
        this.me_id = me_id;
    }
}
