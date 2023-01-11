package main.DAO;

import main.pojo.Mentor;
import java.util.List;

//导师
public interface MentorDao {
    void addMentor(Mentor mentor);
    void updateMentor(Mentor mentor);
    void deleteMentor(String me_id);
    Mentor getMentor(String me_id);
    List<Mentor> findMentors(Mentor mentor);
}
