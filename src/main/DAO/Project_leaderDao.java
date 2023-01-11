package main.DAO;

import main.pojo.Project_leader;

import java.util.List;

public interface Project_leaderDao {
    void addProject_leader(Project_leader project_leader);
    void updateProject_leader(Project_leader project_leader);
    void deleteProject_leader(String pl_id);
    Project_leader getProject_leader(String pl_id);
    List<Project_leader> findProject_leaders(Project_leader project_leader);
}
