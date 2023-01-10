
package entity;

public class Admin {
    private String ad_id = null;
    private String ad_name = null;

    public Admin() {}

    @Override
    public String toString() {
        return "Admin{" +
                "ad_id='" + ad_id + '\'' +
                ", ad_name='" + ad_name + '\'' +
                '}';
    }

    public Admin(String ad_id, String ad_name) {
        this.ad_id = ad_id;
        this.ad_name = ad_name;
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
}