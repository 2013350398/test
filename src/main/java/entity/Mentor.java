
package entity;

public class Mentor {
    private String me_id = null;
    private String me_name = null;

    public Mentor() {}

    @Override
    public String toString() {
        return "Mentor{" +
                "me_id='" + me_id + '\'' +
                ", me_name='" + me_name + '\'' +
                '}';
    }

    public Mentor(String me_id, String me_name) {
        this.me_id = me_id;
        this.me_name = me_name;
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
}