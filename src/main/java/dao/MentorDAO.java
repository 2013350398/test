
package dao;

import entity.Mentor;

import java.util.List;

public interface MentorDAO {

    public List<Mentor> selectAll();

    public Mentor selectByMNo(String me_no);
    public List<Mentor> selectByName(String me_name);
}