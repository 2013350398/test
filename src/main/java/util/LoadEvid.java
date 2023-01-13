
package util;

import java.io.*;
import java.util.Map;

public class LoadEvid {
    public static String uploadEvid(String localPath) {
        StringBuffer filename;

        try {
            File source = new File(localPath);
            FileInputStream fis = new FileInputStream(source);
            filename = new StringBuffer("./evidence/" + source.getName());
            File dfile = new File(filename.toString());
            File pafile=dfile.getParentFile();
            //不存在父路径就创建
            if(!pafile.exists())
                pafile.mkdirs();
            if(!dfile.exists())
                dfile.createNewFile();
            else
                while(dfile.exists()) {
                    filename = filename.insert(filename.indexOf(".", 1), "(1)") ;
                    dfile.renameTo(new File(filename.toString()));
    //                System.out.println(filename + "" + dfile.exists());
                    if(!dfile.exists()){
                        dfile.createNewFile();
                        break;
                    }
                }

            FileOutputStream fos = new FileOutputStream(dfile);
            byte[] b = new byte[1024];
            int len;
            while((len = fis.read(b)) != -1)
                fos.write(b, 0, len);

//            serverPath = dfile.getPath();
//            System.out.println(serverPath);
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filename.toString();
    }

    public static String downloadEvid(String serverPath) {
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");
        System.out.println(userName);
        try {
            File source = new File(serverPath);
            FileInputStream fis = new FileInputStream(source);

            File dfile = new File("C://Users//" + userName + "//Downloads//" + source.getName());
//            System.out.println(dfile.getAbsolutePath());
            if(!dfile.exists())
                dfile.createNewFile();

            FileOutputStream fos = new FileOutputStream(dfile);
            byte[] b = new byte[1024];
            int len;
            while((len = fis.read(b)) != -1)
                fos.write(b, 0, len);

            serverPath = dfile.getPath();
            System.out.println("下载完成!");
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return serverPath;
    }
}