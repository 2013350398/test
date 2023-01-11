package main.DAO;

import main.pojo.Subject;

import java.util.List;

public interface SubjectDao {
    void addSubject(Subject subject);
    void updateSubject(Subject subject);
    void deleteSubject(String su_id);
    Subject getSubject(String su_id);
    List<Subject> findSubjects(Subject subject);
}
