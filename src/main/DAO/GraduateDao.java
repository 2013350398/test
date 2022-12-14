package main.DAO;

import main.pojo.Graduate;

import java.util.List;

public interface GraduateDao {
    void addGraduate(Graduate graduate);
    void updateGraduate(Graduate graduate);
    void deleteGraduate(String gr_id);
    Graduate getGraduate(String gr_id);
    List<Graduate> findGraduates(Graduate graduate);
}
