package main.pojo;

public class Application {
    private String sa_id;
    private String st_id;
    private String co_id;

    public String getSa_id() {
        return sa_id;
    }

    public void setSa_id(String sa_id) {
        this.sa_id = sa_id;
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


    @Override
    public String toString() {
        return "Application{" +
                "sa_id='" + sa_id + '\'' +
                ", st_id='" + st_id + '\'' +
                ", co_id='" + co_id + '\'' +
                '}';
    }
}
