/**
 * @BelongsProject: database_keshe
 * @BelongsPackage: test
 * @ClassName:main
 * @Author: yuzuwxy
 * @CreateTime: 2022-12-12  22:27
 */
package achiev_submit;

import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));
    }
}