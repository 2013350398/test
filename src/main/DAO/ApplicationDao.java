package main.DAO;

import main.CustomType.ApaTeacher;
import main.pojo.Application;

import java.util.List;

public interface ApplicationDao {
    void addApplication(Application application);
    void updateApplication(Application application);
    void deleteApplication(String sa_id);
    Application getApplication(String sa_id);
    List<Application> APPLICATION_LIST();
    List<ApaTeacher> APA_TEACHER_LIST(String tid);
}
