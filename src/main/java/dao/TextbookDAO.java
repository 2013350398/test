
package dao;

import entity.Patent;
import entity.Textbook;

import java.util.List;

public interface TextbookDAO {

    public List<Textbook> selectByNo(String achiev_no);
    public Integer insert(Textbook textbook);
}