
package dao;

import entity.Student;

import java.util.List;

public interface StudentDAO {

    public List<Student> selectAll();

    public Student selectBySNo(String st_no);
    public List<Student> selectByName(String st_name);

}