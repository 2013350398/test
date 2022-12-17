package main.DAO;

import main.pojo.Project;

import java.util.List;

public interface ProjectDao {
    void addProject(Project project);
    void updateProject(Project project);
    void deleteProject(String pr_id);
    Project getProject(String pr_id);
    List<Project> findProjects(Project project);
    List<Project> findProjectsBYMe_id(String me_id);
    List<Project> findProjectsBYPl_id(String pl_id);
    List<Project> getAllProject();
}
