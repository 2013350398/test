package main.DAO;

import main.pojo.Project_indentify;

import java.util.List;

public interface Project_indentifyDao {
    void addProject_indentify(Project_indentify project_indentify);
    void updateProject_indentify(Project_indentify project_indentify);
    void deleteProject_indentify(String pi_id);
    Project_indentify getProject_indentify(String pi_id);
    List<Project_indentify> findProject_indentifys(Project_indentify project_indentify);
}
