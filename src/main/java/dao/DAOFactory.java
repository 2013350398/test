/**
 * @BelongsProject: database_keshe
 * @BelongsPackage: dao
 * @ClassName:DAOFactory
 * @Author: yuzuwxy
 * @CreateTime: 2022-12-22  10:39
 */
package dao;

public class DAOFactory {
    // 单例: 私有静态成员, 加载类时初始化实例, 私有构造函数
    private static  DAOFactory daoFactory;
    static {
        daoFactory = new DAOFactory();
    }
    private  DAOFactory() {}

    public static DAOFactory getInstance() {
        return daoFactory;
    }
}