
package entity;

public class Student {
    private String st_id = null;
    private String st_name = null;

    public Student() {}

    public Student(String st_id, String st_name) {
        this.st_id = st_id;
        this.st_name = st_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "st_id='" + st_id + '\'' +
                ", st_name='" + st_name + '\'' +
                '}';
    }

    public String getSt_id() {
        return st_id;
    }

    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }
}