package main.DAO;

import main.pojo.academic;

import java.util.List;

public interface AcademicDao {
    //签字
    void updateByCharge(String st_id,String sign);
    void updateByMentor(String st_id,String sign);
    //审核所有
    List<academic> verify();
    //学生填写
    void insertByStudent(academic a);

}
